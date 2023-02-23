package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class FallofWicket(
    @SerializedName("Batsman")
    val batsman: String,
    @SerializedName("Score")
    val score: String,
    @SerializedName("Overs")
    val overs: String
)