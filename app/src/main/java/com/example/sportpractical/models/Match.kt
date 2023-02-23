package com.example.sportpractical.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    @SerializedName("Livecoverage")
    val livecoverage: String,
    @SerializedName("Id")
    val id: String,
    @SerializedName("Code")
    val code: String,
    @SerializedName("League")
    val league: String,
    @SerializedName("Number")
    val number: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Date")
    val date: String,
    @SerializedName("Time")
    val time: String,
    @SerializedName("Offset")
    val offset: String,
    @SerializedName("Daynight")
    val daynight: String
) : Parcelable