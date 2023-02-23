package com.example.sportpractical.repositories

import com.example.sportpractical.api.ApiInterface
import javax.inject.Inject

class MainRepo @Inject constructor(
    private val apiInterface: ApiInterface
) {

    suspend fun getSportsData() = apiInterface.getSportsData()
}