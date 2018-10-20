package com.akhil_infinity.akhil.analyzin.Api;

import android.content.Context;
import android.util.Log;

import com.akhil_infinity.akhil.analyzin.Constants;
import com.akhil_infinity.akhil.analyzin.MainActivity;
import com.akhil_infinity.akhil.analyzin.interfaces.AuthenticationListener;
import com.akhil_infinity.akhil.analyzin.interfaces.UIUpdater;
import com.akhil_infinity.akhil.analyzin.models.UserData;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class ApiRequest {
//    public void
    private Context mContext;
    private UIUpdater mUpdater;
    private String mAccessToken = null;
    private GenerateApiUrl mGenerateApiUrl;

    public ApiRequest(Context context, UIUpdater updater){
        this.mContext = context;
        this.mAccessToken = context
                .getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
                .getString("token", null);
        this.mGenerateApiUrl = new GenerateApiUrl();
        this.mUpdater = updater;
    }

    public void getUserInformation(){
        String url = mGenerateApiUrl.generateUserInfoUrl(mAccessToken);
        ApiRequestClient.get(url,null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.d("user_info_response", "onSuccess: " + response);

                UserData user = new UserData(response);
                mUpdater.updateUI(user);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("user_info", "onFailure: " + errorResponse);
            }
        });
    }
}
