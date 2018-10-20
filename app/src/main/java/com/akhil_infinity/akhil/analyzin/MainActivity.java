package com.akhil_infinity.akhil.analyzin;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.akhil_infinity.akhil.analyzin.Api.ApiRequest;
import com.akhil_infinity.akhil.analyzin.CustomViews.AuthenticationDialog;
import com.akhil_infinity.akhil.analyzin.interfaces.AuthenticationListener;
import com.akhil_infinity.akhil.analyzin.interfaces.UIUpdater;
import com.akhil_infinity.akhil.analyzin.models.UserData;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements AuthenticationListener, UIUpdater {
    private AuthenticationDialog mAuth_dialog;
    private SharedPreferences mSharedPref = null;
    private String token = null;

    TextView mFullName;
    TextView mBioMessage;
    ImageView mProfileImageView;
    TextView mMediaCount;
    TextView mFollowersCount;
    TextView mFollowingCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFullName = findViewById(R.id.full_name);
        mBioMessage = findViewById(R.id.bio);
        mProfileImageView = findViewById(R.id.profile_image_view);
        mMediaCount = findViewById(R.id.media_text_view);
        mFollowersCount = findViewById(R.id.followers_text_view);
        mFollowingCount = findViewById(R.id.following_text_view);

        //Check the prefetch for existing auth token
        mSharedPref = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        token = mSharedPref.getString("token", null);
        if(token != null){
            //if an authentication token was found
            Log.d("access_token_1", token + " not Null");
            //retrieve profile information
            new ApiRequest(this, this).getUserInformation();
        }else{
            //if no authentication token was found.
            mAuth_dialog = new AuthenticationDialog(this,this);
            mAuth_dialog.setCancelable(true);
            mAuth_dialog.show();
        }
    }

    @Override
    public void onCodeReceived(String auth_token) {
        if (auth_token == null)
            return;
        //Add the value to shared preferences
        Log.d("access_token_1", auth_token);
        SharedPreferences.Editor editor = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE).edit();
        editor.putString("token", auth_token);
        editor.apply();
    }

    @Override
    public void updateUI(UserData user) {
        Log.d("UserData", "updateUI: " + user.getFullName());
         mFullName.setText(user.getFullName());
         mBioMessage.setText(user.getBio());
        Picasso.get().load(user.getProfilePicture()).resize(500,500).into(mProfileImageView);
         mMediaCount.setText(user.getMediaCount());
         mFollowersCount.setText(user.getFollowersCount());
         mFollowingCount.setText(user.getFollowingCount());
    }
}
