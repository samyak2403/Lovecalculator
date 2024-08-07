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