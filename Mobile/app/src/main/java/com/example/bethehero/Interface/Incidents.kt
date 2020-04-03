package com.example.bethehero.Interface

import com.example.bethehero.Model.Incident
import retrofit2.Call
import retrofit2.http.GET

interface Incidents {
    @GET("incidents")
    fun getIncidents(id : String) : Call<List<Incident>>
}