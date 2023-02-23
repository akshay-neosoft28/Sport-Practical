package com.example.sportpractical.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bowling(
    @SerializedName("Style")
    val style: String,
    @SerializedName("Average")
    val average: String,
    @SerializedName("Economyrate")
    val economyrate: String,
    @SerializedName("Wickets")
    val wickets: String
): Parcelable