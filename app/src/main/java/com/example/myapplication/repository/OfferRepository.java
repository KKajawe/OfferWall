package com.example.myapplication.repository;

import com.example.myapplication.remote.responseModel.OfferModel;

import java.util.Map;

import retrofit2.Response;

public abstract class OfferRepository {
   abstract public OfferModel getOfferList(Map<String, String> options);
    public boolean validateResponse(Response<OfferModel> response) {
        if (response == null || !response.isSuccessful()) {
            return false;
        }
        return true;
    }
    public Boolean handleSuccessResponse(OfferModel responseBody) {
        if(responseBody == null)
            return  false;
        if (responseBody.getCode() == null || responseBody.getCode().isEmpty() || !responseBody.getCode().equalsIgnoreCase("ok")) {
            return false;
        } else if (responseBody.getMessage() == null || responseBody.getMessage().isEmpty() || !responseBody.getMessage().equalsIgnoreCase("ok")) {
            return false;
        } else if (responseBody.getOffersList() == null || responseBody.getOffersList().isEmpty() || responseBody.getOffersList().size() <= 0)
            return false;
        return true;
    }
    public void handleErrorResponse(String code , OfferModel data) {

    }
}
