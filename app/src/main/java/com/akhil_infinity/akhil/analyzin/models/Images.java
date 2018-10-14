package com.akhil_infinity.akhil.analyzin.models;

public class Images {
    private StandardResolutiton standardResolutiton;

    public StandardResolutiton getStandardResolutiton() {
        return standardResolutiton;
    }

    public class StandardResolutiton{
        private String url;
        public String getUrl(){
            return url;
        }
    }
}
