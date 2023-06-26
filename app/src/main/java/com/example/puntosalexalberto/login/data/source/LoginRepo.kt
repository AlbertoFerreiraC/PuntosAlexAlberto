package com.example.puntosalexalberto.login.data.source

import android.util.Log
import com.example.puntosalexalberto.login.data.source.network.LoginApi
import com.example.puntosalexalberto.login.data.source.network.LoginRequest
import com.example.puntosalexalberto.login.data.source.network.LoginResponse
import com.example.puntosalexalberto.login.domain.ILoginRepo
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
  *@author Julio Cabrera
  *Create 26/6/2023 at 08:52
  **/
class LoginRepo: ILoginRepo {

    private val TAG = "LoginRepo"

    override suspend fun login(user: String, pass: String): Boolean {

        Log.w(TAG, "login: inicio", )
        
        val retrofit = Retrofit.Builder()
            .baseUrl("http://ingrid-desa.alexsa.com.py/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        try {
            val loginApi = retrofit.create(LoginApi::class.java)
            Log.w(TAG, "login: create", )
            val responseApi = loginApi.login(LoginRequest(user,pass))

            Log.w(TAG, "login: loginApi", )

            if (responseApi.isSuccessful){
                val loginResponse = responseApi.body() as LoginResponse
                Log.w(TAG, "login: $loginResponse")
            }else{
                Log.e(TAG, "login: ERROR", )
            }
        }catch (e:Exception){

            Log.e(TAG, "error login: ${e.message}", e)
        }




        return true
    }
}