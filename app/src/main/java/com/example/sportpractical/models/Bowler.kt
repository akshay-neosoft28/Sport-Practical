package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class Bowler(
    @SerializedName("Bowler")
    val bowler: String,
    @SerializedName("Overs")
    val overs: String,
    @SerializedName("Maidens")
    val maidens: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Wickets")
    val wickets: String,
    @SerializedName("Economyrate")
    val economyrate: String,
    @SerializedName("Noballs")
    val noballs: String,
    @SerializedName("Wides")
    val wides: String,
    @SerializedName("Dots")
    val dots: String,
    @SerializedName("Isbowlingtandem")
    val isbowlingtandem: Boolean,
    @SerializedName("Isbowlingnow")
    val isbowlingnow: Boolean,
    @SerializedName("ThisOver")
    val thisOver: List<ThisOver>
)