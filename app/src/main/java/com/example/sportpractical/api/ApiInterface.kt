package com.example.sportpractical.api

import com.example.sportpractical.models.SportsData
import retrofit2.http.GET

interface ApiInterface {

    /**
     * API method: GET
     * USE: get sports data
     */
    @GET("nzin01312019187360.json")
    suspend fun getSportsData(): Result<SportsData>

    /**
     * API method: GET
     * USE: get sports data for another match
     */
    @GET("sapk01222019186652.json")
    suspend fun getSportsData2(): Result<SportsData>
}