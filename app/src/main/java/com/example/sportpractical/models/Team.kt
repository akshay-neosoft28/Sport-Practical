package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Name_Short")
    val nameShort: String,
    @SerializedName("Players")
    val players: Map<String, Player>
)