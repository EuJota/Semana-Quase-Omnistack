package com.example.bethehero.Interface

import com.example.bethehero.Model.Ong
import retrofit2.Call
import retrofit2.http.GET

interface Ongs {
    @GET("ongs")
    fun getOngs() : Call<List<Ong>>
}