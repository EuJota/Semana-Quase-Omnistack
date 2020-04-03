package com.example.bethehero.Model

import com.google.gson.annotations.SerializedName


//TODO LISTAR AS ONGS A PARTIR DO UF

data class Ong(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("whatsapp")
    val whatsapp: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("uf")
    val uf: String
)
