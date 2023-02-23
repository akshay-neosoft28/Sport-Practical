package com.example.sportpractical.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Matchdetail(
    @SerializedName("Team_Home")
    val teamHome: String,
    @SerializedName("Team_Away")
    val teamAway: String,
    @SerializedName("Match")
    val match: Match,
    @SerializedName("Venue")
    val venue: Venue,
    @SerializedName("Weather")
    val weather: String,
    @SerializedName("Tosswonby")
    val tosswonby: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Status_Id")
    val statusId: String,
    @SerializedName("Player_Match")
    val playerMatch: String,
    @SerializedName("Result")
    val result: String,
    @SerializedName("Winningteam")
    val winningteam: String,
    @SerializedName("Winmargin")
    val winmargin: String,
    @SerializedName("Equation")
    val equation: String
): Parcelable