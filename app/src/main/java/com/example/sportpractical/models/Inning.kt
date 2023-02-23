package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class Inning(
    @SerializedName("Number")
    val number: String,
    @SerializedName("Battingteam")
    val battingteam: String,
    @SerializedName("Total")
    val total: String,
    @SerializedName("Wickets")
    val wickets: String,
    @SerializedName("Overs")
    val overs: String,
    @SerializedName("Runrate")
    val runrate: String,
    @SerializedName("Byes")
    val byes: String,
    @SerializedName("Legbyes")
    val legbyes: String,
    @SerializedName("Wides")
    val wides: String,
    @SerializedName("Noballs")
    val noballs: String,
    @SerializedName("Penalty")
    val penalty: String,
    @SerializedName("AllottedOvers")
    val allottedOvers: String,
    @SerializedName("Batsmen")
    val batsmen: List<Batsmen>,
    @SerializedName("Partnership_Current")
    val partnershipCurrent: PartnershipCurrent,
    @SerializedName("Bowlers")
    val bowlers: List<Bowler>,
    @SerializedName("FallofWickets")
    val fallofWickets: List<FallofWicket>,
    @SerializedName("PowerPlay")
    val powerPlay: PowerPlay,
    @SerializedName("Target")
    val target: String
)