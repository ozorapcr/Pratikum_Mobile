package com.example.marvelapps.data.api

import com.example.marvelapps.data.model.PhotoModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/list")
    fun getPhotos(): Call<List<PhotoModel>>
}
