package com.kee.vlmusic.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://satkaivalsaheb.xyz/admin_start/admin_start/admin/html/ltr/";


    public static Retrofit getApiclient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;
    }
}
