package com.elifcan.cargallery.config;

public class RestApi {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String BASE_URL = DEV + VERSION;

    public static final String CAR = BASE_URL + "/cart";
    public static final String USER = BASE_URL + "/user";


    public static final String REGISTER_USER = "/register-user";
    public static final String ADD_CAR = "/add-car";
    public static final String LIST_CAR = "/list-car";
    public static final String UPDATE_CAR = "/update-car";
    public static final String DELETE_PRODUCT = "/delete-car";
    public static final String LOGIN_USER = "/login-user";
    public static final String ADD_ROLE = "/add-role";
}
