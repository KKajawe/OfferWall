package com.example.myapplication.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleTon {
    public static GetOfferApi getOfferApi;

    public static GetOfferApi getOfferApi() {
        if (getOfferApi == null) {
            return new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://api.fyber.com/")
                    .build()
                    .create(GetOfferApi.class);
        } else
            return getOfferApi;
    }
}
