package com.example.myapplication.other;

import java.util.HashMap;
import java.util.Map;

public class QueryMapForOfferData {
    private   Map<String, String> parameters = new HashMap<String, String>();
    public Map<String, String> getParameters(Map<String, String> userInputParams) {
        parameters.put("appid", userInputParams.get("appid"));
        parameters.put("uid", userInputParams.get("uid"));
        parameters.put("hashkey", userInputParams.get("hashkey"));
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



}
