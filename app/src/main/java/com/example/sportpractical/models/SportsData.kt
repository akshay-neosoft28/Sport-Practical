package com.example.sportpractical.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SportsData(
    @SerializedName("Matchdetail")
    val matchdetail: Matchdetail,
    @SerializedName("Nuggets")
    val nuggets: List<String>,
    @SerializedName("Teams")
    val teams: Map<String, Team>,
): Parcelable