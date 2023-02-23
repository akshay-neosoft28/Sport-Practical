package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class Bowling(
    @SerializedName("Style")
    val style: String,
    @SerializedName("Average")
    val average: String,
    @SerializedName("Economyrate")
    val economyrate: String,
    @SerializedName("Wickets")
    val wickets: String
)