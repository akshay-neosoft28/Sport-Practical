package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class PartnershipCurrent(
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Balls")
    val balls: String,
    @SerializedName("Batsmen")
    val batsmen: List<Batsmen>
)