package com.example.myapplication.remote;

import com.example.myapplication.remote.responseModel.OfferModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GetOfferApi {
    @GET("feed/v1/offers.json")
    Call<OfferModel> getOfferList(@QueryMap Map<String, String> options);
}
