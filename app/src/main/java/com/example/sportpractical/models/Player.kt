package com.example.sportpractical.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    @SerializedName("Position")
    val position: String,
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Iscaptain")
    val iscaptain: Boolean?,
    @SerializedName("Iskeeper")
    val iskeeper: Boolean?,
    @SerializedName("Batting")
    val batting: Batting,
    @SerializedName("Bowling")
    val bowling: Bowling
): Parcelable