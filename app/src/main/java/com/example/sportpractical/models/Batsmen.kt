package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class Batsmen(
    @SerializedName("Batsman")
    val batsman: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Balls")
    val balls: String,
    @SerializedName("Fours")
    val fours: String,
    @SerializedName("Sixes")
    val sixes: String,
    @SerializedName("Dots")
    val dots: String,
    @SerializedName("Strikerate")
    val strikerate: String,
    @SerializedName("Dismissal")
    val dismissal: String,
    @SerializedName("Howout")
    val howout: String,
    @SerializedName("Bowler")
    val bowler: String,
    @SerializedName("Fielder")
    val fielder: String,
    @SerializedName("Isonstrike")
    val isonstrike: Boolean
)