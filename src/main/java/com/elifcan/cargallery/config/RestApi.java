package com.elifcan.cargallery.config;

public class RestApi {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String BASE_URL = DEV + VERSION;

    public static final String CAR = BASE_URL + "/cart";
    public static final String USER = BASE_URL + "/user";


    public static final String REGISTER_USER = "/register-user";
    public static final String LOGIN_USER = "/login-user";
    public static final String ADD_ROLE = "/add-role";
}
