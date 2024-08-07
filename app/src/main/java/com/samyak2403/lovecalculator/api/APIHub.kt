package com.samyak2403.lovecalculator.api

import com.samyak2403.lovecalculator.ui.model.LoveResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIHub {


    @Headers("x-rapidapi-host:love-calculator.p.rapidapi.com",
    "x-rapidapi-key:497520bf78msh056685b336d909dp1e6101jsn9382390ed7ab")
    @GET(".")
    suspend fun getPercentage(
        @Query("fname") fName : String,
        @Query("sname") sName : String,
    ) : LoveResponse

}