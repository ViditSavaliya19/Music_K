package com.kee.vlmusic.Utils;


import com.kee.vlmusic.Model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinetface {

    @GET("wallpaperapi.php/")
     Call<List<Example>> getUser();

    @GET("musicapi.php/")
    Call<List<Example>> getMusic();

    @GET("api.php/?")
    Call<Example> getSerachUser(@Query("id") String username);
}
