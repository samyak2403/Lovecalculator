package com.samyak2403.lovecalculator.repository

import android.util.Log
import com.samyak2403.lovecalculator.api.APIHub
import com.samyak2403.lovecalculator.ui.model.LoveResponse
import java.lang.Exception
import javax.inject.Inject

class LoveRepository @Inject constructor(private val apiHub: APIHub) {

    suspend fun getPercentage(fName: String, sName: String): LoveResponse {

        val response = try{

            apiHub.getPercentage(fName, sName)

        }catch(e: Exception){

            Log.d("LOVE-API", "Error: ${e.message}")

            return LoveResponse( "Error", "Error")
            //you can handle errors using sealed class or any convenient methods.
            //I skipped due to the simplicity of this project
        }
        return response

    }

}