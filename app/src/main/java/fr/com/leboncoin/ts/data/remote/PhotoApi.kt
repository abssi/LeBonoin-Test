package fr.com.leboncoin.ts.data.remote

import fr.com.leboncoin.ts.data.Photo
import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi{

    @GET("technical-test.json")
    fun listPhotos(): Call<List<Photo>>

}