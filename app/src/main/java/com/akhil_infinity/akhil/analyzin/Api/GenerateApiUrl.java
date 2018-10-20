package com.akhil_infinity.akhil.analyzin.Api;

import com.akhil_infinity.akhil.analyzin.Constants;

public class GenerateApiUrl {

    public String generateAuthUrl(){
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.BASE_URL);
        builder.append("oauth/authorize/?client_id=");
        builder.append(Constants.INSTAGRAM_CLIENT_ID);
        builder.append("&redirect_uri=");
        builder.append(Constants.REDIRECT_URL);
        builder.append("&display=touch&scope=public_content&response_type=token");
        return builder.toString();
    }


    public String generateUserInfoUrl(String accessToken){
        return "users/self/?access_token="+accessToken;
    }

}
