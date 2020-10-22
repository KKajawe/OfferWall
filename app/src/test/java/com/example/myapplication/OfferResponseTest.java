package com.example.myapplication;

import com.example.myapplication.remote.responseModel.OfferModel;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;


public class OfferResponseTest extends FakeOfferRepository {
    private OfferModel offerResponse;
    private OfferModel invalidOfferResponse;


    @Before
    public void setup() throws IOException {
        String result = new MockResponseJsonFileReader("src/test/resources/offerData.Json").readJsonFile();
        String invalidResult = new MockResponseJsonFileReader("src/test/resources/invalidOfferResponseData.Json").readJsonFile();
        Gson g = new Gson();
        offerResponse = g.fromJson(result, OfferModel.class);
        invalidOfferResponse = g.fromJson(invalidResult, OfferModel.class);
        System.out.println(invalidOfferResponse.toString());
    }

    @Test
    public void checkResponse() {
        Boolean response = validateResponse(null);
        assertThat(response).isFalse();
    }

    /*
     *...make code  "" in hardcoded Json file invalidOfferResponseData then test
     *...as code is "" fun handleSuccessResponse returns false
     *...and our test invalidCodeInResponseBody says - if code is empty then the expected result is false
     * **as fun handleSuccessResponse and our test invalidCodeInResponseBody both returns false
     * **that means fun handleSuccessResponse logic is right and so the test is passed
     */
    @Test
    public void invalidCodeInResponseBody() {
        Boolean result = handleSuccessResponse(invalidOfferResponse);
        assertThat(result).isFalse();
    }

    /*
     *...make message null in hardcoded Json file invalidOfferResponseData then test
     *...as message is null fun handleSuccessResponse returns false
     *...and our test invalidMessageInResponseBody says - if message is empty then the expected result is false
     * **as fun handleSuccessResponse and our test invalidMessageInResponseBody both returns false
     * **that means fun handleSuccessResponse logic is right and so the test is passed
     */
    @Test
    public void invalidMessageInResponseBody() {
        Boolean result = handleSuccessResponse(invalidOfferResponse);
        assertThat(result).isFalse();
    }

    /*
     *...make offerList empty in hardcoded Json file invalidOfferResponseData then test
     *...as offerList is empty fun handleSuccessResponse returns false
     *...and our test invalidOfferListInResponseBody says - if offerList is empty then the expected result is false
     * **as fun handleSuccessResponse and our test invalidOfferListInResponseBody both returns false
     * **that means fun handleSuccessResponse logic is right and so the test is passed
     */
    @Test
    public void invalidOfferListInResponseBody() {
        Boolean result = handleSuccessResponse(invalidOfferResponse);
        assertThat(result).isFalse();
    }

    /*
    test should pass for valid Json response
     */
    @Test
    public void validResponseBody() {
        Boolean result = handleSuccessResponse(offerResponse);
        assertThat(result).isTrue();
    }




}