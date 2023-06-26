package com.example.puntosalexalberto.login.data.source.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
  *@author Julio Cabrera
  *Create 26/6/2023 at 08:51
  **/
interface LoginApi {

    @POST("auth/")
    suspend fun login(@Body login: LoginRequest): Response<LoginResponse>

}