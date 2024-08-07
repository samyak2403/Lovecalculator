/**MIT License

Copyright (c) 2024 Samyak Kamble

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
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