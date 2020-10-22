package com.example.myapplication.remote.responseModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class OfferModel {

    private String code;

    private String message;

    @SerializedName("offers")
    private List<Offers> offersList = null;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Offers> getOffersList() {
        return offersList;
    }
}
