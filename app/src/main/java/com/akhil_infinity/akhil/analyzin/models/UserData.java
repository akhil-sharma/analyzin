package com.akhil_infinity.akhil.analyzin.models;

//import java.util.ArrayList;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

public class UserData {
    //private String mAccessToken;
    //private ArrayList<FollowerData> mFollowers;
    private String mBio;
    private String mFollowersCount;
    //private ArrayList<FollowerData> mFollowing;
    private String mFollowingCount;
    private String mFullName;
    private String mUID;
    private String mProfilePicture;
    private String mUserName;
    private String mWebsite;
    private String mMediaCount;

    public UserData(JSONObject userJSONObject) {
        try{
            JSONObject response = (JSONObject) userJSONObject.get("data");
            this.mUID = response.getString("id");
            this.mProfilePicture = response.getString("profile_picture");
            this.mUserName = response.getString("username");
            this.mBio = response.getString("bio");
            this.mWebsite = response.getString("website");
            this.mFollowersCount = String.valueOf(((JSONObject)response.get("counts")).getInt("followed_by"));
            this.mFollowingCount = String.valueOf(((JSONObject)response.get("counts")).getInt("follows"));
            this.mMediaCount = String.valueOf((((JSONObject)response.get("counts")).getInt("media")));
            this.mFullName = response.getString("full_name");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getMediaCount() {
        return mMediaCount;
    }

    public void setMediaCount(String mediaCount) {
        mMediaCount = mediaCount;
    }

    //public String getAccessToken() {
    //    return mAccessToken;
    //}

    //public void setAccessToken(String accessToken) {
      //  mAccessToken = accessToken;
    //}

//    public ArrayList<FollowerData> getFollowers() {
//        return mFollowers;
//    }

//    public void setFollowers(ArrayList<FollowerData> followers) {
//        mFollowers = followers;
//    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public String getFollowersCount() {
        return mFollowersCount;
    }

    public void setFollowersCount(String followersCount) {
        mFollowersCount = followersCount;
    }

//    public ArrayList<FollowerData> getFollowing() {
//        return mFollowing;
//    }

//    public void setFollowing(ArrayList<FollowerData> following) {
//        mFollowing = following;
//    }

    public String getFollowingCount() {
        return mFollowingCount;
    }

    public void setFollowingCount(String followingCount) {
        mFollowingCount = followingCount;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getUID() {
        return mUID;
    }

    public void setUID(String UID) {
        mUID = UID;
    }

    public String getProfilePicture() {
        return mProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        mProfilePicture = profilePicture;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String webSite) {
        mWebsite = webSite;
    }

    public void copy(UserData userData) {
        //this.mAccessToken = userData.getAccessToken();
        this.mUID = userData.getUID();
        this.mProfilePicture = userData.getProfilePicture();
        this.mUserName = userData.getUserName();
        this.mBio = userData.getBio();
        this.mWebsite = userData.getWebsite();
        this.mFollowersCount = userData.getFollowersCount();
        this.mFollowingCount = userData.getFollowingCount();
        this.mFullName = userData.getFullName();
//        this.mFollowers = userData.getFollowers();
//        this.mFollowing = userData.getFollowing();
    }

//    public void writeToParcel(Parcel parcel) {
//        //parcel.writeString(this.mAccessToken);
//        parcel.writeString(this.mUID);
//        parcel.writeString(this.mProfilePicture);
//        parcel.writeString(this.mUserName);
//        parcel.writeString(this.mBio);
//        parcel.writeString(this.mWebsite);
//        parcel.writeString(this.mFollowersCount);
//        parcel.writeString(this.mFollowingCount);
//        parcel.writeString(this.mFullName);
//    }
//
//    public void UserData(Parcel parcel) {
//        //this.mAccessToken = parcel.readString();
//        this.mUID = parcel.readString();
//        this.mProfilePicture = parcel.readString();
//        this.mUserName = parcel.readString();
//        this.mBio = parcel.readString();
//        this.mWebsite = parcel.readString();
//        this.mFollowersCount = parcel.readString();
//        this.mFollowingCount = parcel.readString();
//        this.mFullName = parcel.readString();
////        this.mFollowers = userData.getFollowers();
////        this.mFollowing = userData.getFollowing();
//    }

}