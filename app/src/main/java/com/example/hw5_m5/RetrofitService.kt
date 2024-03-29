package com.example.hw5_m5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John

object RetrofitService {
    val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api = retrofit.create(LoveApi::class.java)
}