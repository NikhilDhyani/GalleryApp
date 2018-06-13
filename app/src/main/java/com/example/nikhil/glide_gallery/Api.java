package com.example.nikhil.glide_gallery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NIKHIL on 13-06-2018.
 */

public interface Api {

    //todo 3 : Here we define base url

    String base_url = "https://api.androidhive.info/json/";

    //todo 4: Enter end point and method. Ex: Get, Post etc

    @GET("glide.json")
    Call<List<Photo>> getPhotos();
}
