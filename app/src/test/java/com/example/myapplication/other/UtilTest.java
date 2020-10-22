package com.example.myapplication.other;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;


public class UtilTest {
    private String appId = "2070";
    private String userId = "superman";
    private String securityToken = "1c915e3b5d42d05136185030892fbb846c278927";


    public Map<String, String> getQueryMapParameters() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("appid", appId);
        parameters.put("uid", userId);
        parameters.put("hashkey", securityToken);
        parameters.put("ip", "109.235.143.113");
        parameters.put("locale", "DE");
        parameters.put("device_id", "device_id");
        parameters.put("pub0", "CUSTOM");
        parameters.put("timestamp", "UNIX_timestamp");
        parameters.put("offer_types", "112");
        parameters.put("phone_version", "phone_version");
        parameters.put("apple_idfa", "IP_ADDRESS");
        parameters.put("apple_idfa_tracking_enabled", "IDFA ENABLED");
        parameters.put("google_ad_id", "GA ID");
        parameters.put("google_ad_id_limited_tracking_enabled", "true");
        return parameters;
    }


    /*
     *...appId is ""
     *...as appId is empty fun validateUserInput returns false
     *...and our test emptyUserInput says - if any user input is empty then the expected result is false
     * **as fun validateUserInput and our test emptyUserInput both returns false
     * **that means fun validateUserInput logic is right and so the test is passed
     */
    @Test
    public void emptyUserInput() {
        Boolean result = Util.validateUserInput("", userId, securityToken);
        assertThat(result).isFalse();
    }

    /*
     *...userId is null
     *...as userId is null fun validateUserInput returns false
     *...and our test nullUserInput says - if any user input is null then the expected result is false
     *  **as fun validateUserInput and our test nullUserInput both returns false
     *  **that means fun validateUserInput logic is right and so the test is passed
     */
    @Test
    public void nullUserInput() {
        Boolean result = Util.validateUserInput(appId, null, securityToken);
        assertThat(result).isFalse();
    }

    /*
     *...User inputs are not null and not empty
     *...and so the fun validateUserInput returns true
     *...and our test validUserInput says - if all user inputs are not null and not empty then the expected result is true
     *  **as fun validateUserInput and our test validUserInput both returns true
     *  **that means fun validateUserInput logic is right and so the test is passed
     */
    @Test
    public void validUserInput() {
        Boolean result = Util.validateUserInput(appId, userId, securityToken);
        assertThat(result).isTrue();
    }

    /*
     * for retrofit get offer api requires QueryMap
     * if that hashMap is not null or empty, then functionwill return true and
     * and our test validQueryParameters says - if all QueryMap parameters is not null or not empty then the expected result is true
     *  **as fun validateQueryParams and our test validQueryParameters both returns true
     *  **that means fun validateQueryParams logic is right and so the test is passed
     */
    @Test
    public void validQueryParameters() {
        Boolean result = Util.validateQueryParams(getQueryMapParameters());
        assertThat(result).isTrue();
    }

    /*
     * for retrofit get offer api requires QueryMap
     * if that hashMap is not null or empty, then functionwill return true else false
     * and our test inValidQueryParameters says - if  QueryMap parameters is  null or empty then the expected result is false
     *  **as fun validateQueryParams and our test inValidQueryParameters both returns true
     *  **that means fun validateQueryParams logic is right and so the test is passed
     */
    @Test
    public void inValidQueryParameters() {
        Boolean result = Util.validateQueryParams(getQueryMapParameters());
        assertThat(result).isFalse();
    }

}