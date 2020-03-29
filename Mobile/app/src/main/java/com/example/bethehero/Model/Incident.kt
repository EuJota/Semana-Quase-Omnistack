package com.example.bethehero.Model

import com.google.gson.annotations.SerializedName

//TODO IMPLEMENTAR A LISTAGEM DE CASOS DE ACORDO A CADA ONG

data class Incident(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("value")
    val value: Float,
    @SerializedName("ong_id")
    val ong_id: String,
    @SerializedName("name")
    val ongName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("whatsapp")
    val whatsapp: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("uf")
    val uf: String

)