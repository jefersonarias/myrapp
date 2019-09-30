package com.example.myrapp

import com.example.myrapp.Pojitos.Posts
import retrofit2.Call
import retrofit2.http.GET

interface ApiSer {
    @GET ( "/posts")
    fun getpost () : Call<List<Posts>>
}