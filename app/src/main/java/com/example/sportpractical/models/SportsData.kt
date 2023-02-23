package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

data class SportsData(
    @SerializedName("Matchdetail")
    val matchdetail: Matchdetail,
    @SerializedName("Nuggets")
    val nuggets: List<String>,
    @SerializedName("Innings")
    val innings: List<Inning>,
    @SerializedName("Teams")
    val teams: Map<String, Team>,
    @SerializedName("Notes")
    val notes: Notes
)