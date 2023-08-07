package com.example.puntosalexalberto.login.data.source.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("auth/")
    suspend fun login(@Body login: LoginRequest): Response<LoginResponse>
}