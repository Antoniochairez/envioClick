package com.inteisystem.apienvioclick.helpers;

/**
 * Created by Antonio Chairez on 1/15/20.
 */

public class constants {

    private static String GET_URL_BASE = "https://api.envioclickpro.com/api/v1/";
    public static String GET_URL_DEFINITIONS = "https://api.envioclickpro.com/#/definitions";

    public static String POST_QUOTATION = "ODB01";
    public static String POST_TRACK = "ODB02";

    public static String CLASS_QUOTATION = "Quotation";
    public static String CLASS_SHIPMENT = "Shipment";
    public static String CLASS_TRACKING = "Tracking";


    // Code response back
    public static int TAG_CODE_200 = 200;
    public static int TAG_CODE_422 = 422;
    public static int TAG_CODE_401 = 401;
    public static int TAG_CODE_403 = 403;
    public static int TAG_CODE_499 = 499;

    public static String TAG_IS_SUCCESS = "Succes";
    public static String TAG_IS_ERROR = "Error";
    public static String TAG_IS_PENDING = "Pending";

    public static String TAG_DESCRIPTION = "description";

    public static String POST = "POST";
    public static String GET = "GET";


    public static String TAG_REQUEST_ERROR = "error";
    public static String TAG_RESPONSE_DATA = "data";

    public static String TAG_USER_KEY= "apiKeyUser";

    // response Data Track
    public static String TAG_RESPONSE_TRACK_STATUS = "status";
    public static String TAG_RESPONSE_TRACK_STATUSDETAIL = "statusDetail";
    public static String TAG_RESPONSE_TRACK_ARRIVALDATE = "arrivalDate";
    public static String TAG_RESPONSE_TRACK_REALPICKUPDATE = "realPickupDate";
    public static String TAG_RESPONSE_TRACK_REALDELIVERYDATE = "realDeliveryDate";
    public static String TAG_RESPONSE_TRACK_RECEIVEBY = "receivedBy";

}


