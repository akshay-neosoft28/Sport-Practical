package com.example.sportpractical.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Name_Short")
    val nameShort: String,
    @SerializedName("Players")
    val players: Map<String, Player>
): Parcelable