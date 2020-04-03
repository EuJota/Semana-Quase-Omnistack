package com.example.bethehero.Interface

import com.example.bethehero.Model.Incident
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Incidents {
    @GET("incidentss/{ong_id}")
fun getIncidents(@Path ("ong_id") id : String) : Call<List<Incident>>
}

/**
 * Como eu faço a solicitação do ong_id como requet.param na api, preciso utilizar o path parameter do retrofit para enviar o dado
 * certinho para a requisição na api
 */
