package com.example.myapplication.remote.responseModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Offers {
    private String title;
    private String offer_id;
    @SerializedName("thumbnail")
    private Thumbnail thumbnail;


    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getOffer_id() {
        return offer_id;
    }
}
