package com.example.myapplication.repository;

import com.example.myapplication.remote.RetrofitSingleTon;
import com.example.myapplication.remote.responseModel.OfferModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultOfferRepository extends OfferRepository {

    private OfferModel offerResponse = null;

    @Override
    public OfferModel getOfferList(Map<String, String> parameters) {
        Call<OfferModel> response = RetrofitSingleTon.getOfferApi().getOfferList(parameters);
        response.enqueue(new Callback<OfferModel>() {
            @Override
            public void onResponse(Call<OfferModel> call, Response<OfferModel> response) {
                if (validateResponse(response)) {
                    if (handleSuccessResponse(response.body())) {
                        returnResponse(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<OfferModel> call, Throwable t) {
                //e.g network error
                handleErrorResponse("Error" , null);
            }
        });
        return offerResponse;
    }



    public OfferModel returnResponse(OfferModel offerResponse) {
        return offerResponse;
    }




}
