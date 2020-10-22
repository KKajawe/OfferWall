package com.example.myapplication;

import com.example.myapplication.remote.responseModel.OfferModel;
import com.example.myapplication.repository.OfferRepository;
import com.google.gson.Gson;

import org.junit.Before;

import java.io.IOException;
import java.util.Map;

public class FakeOfferRepository extends OfferRepository {
    private Boolean shouldReturnNetworkError = false;

    private void setShouldReturnNetworkError(Boolean value) {
        shouldReturnNetworkError = value;
    }

    private OfferModel offerResponse;

    @Before
    public void setup() throws IOException {
        String result = new MockResponseJsonFileReader("src/test/resources/offerData.Json").readJsonFile();
        Gson g = new Gson();
        offerResponse = g.fromJson(result, OfferModel.class);
    }

    @Override
    public OfferModel getOfferList(Map<String, String> options) {

        if (shouldReturnNetworkError) {
            handleErrorResponse("Error", null);
            return null;

        } else {
            handleSuccessResponse(null);
            return offerResponse;

        }
    }
}
