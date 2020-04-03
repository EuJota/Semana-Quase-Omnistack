package com.example.bethehero.Interface

import com.example.bethehero.Model.Incident
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Incidents {
    @GET("incidents")
fun getIncidents(@Query ("ong_id") id : String) : Call<List<Incident>>
}