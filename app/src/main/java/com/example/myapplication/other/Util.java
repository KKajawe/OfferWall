package com.example.myapplication.other;

import java.util.Map;

public class Util {
    /**
     *  ... if anyone of the parameters are null or empty then
     *  .... return false
     *  .....else true
    **/
    public static boolean validateUserInput(String appId, String userId, String Token){
        if (appId == null || userId == null ||Token== null){
            return false;
        }
        if(appId.isEmpty() || userId.isEmpty() || Token.isEmpty()){
            return false;
        }
      return true;
    }
    /**
     *  ... if anyone of the parameters are null or empty then
     *  .... return false
     *  .....else true
     **/
    public static Boolean validateQueryParams(Map<String, String> params) {
        if (params.isEmpty()) {
            return false;
        } else if (params.size() == 0) {
            return false;
        } else if (params == null) {
            return false;
        }
        return true;
    }

}
