package com.example.sportpractical.models


import com.google.gson.annotations.SerializedName

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
)