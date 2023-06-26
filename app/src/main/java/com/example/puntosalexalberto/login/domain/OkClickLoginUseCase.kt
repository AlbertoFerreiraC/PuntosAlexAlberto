package com.example.puntosalexalberto.login.domain

import android.util.Log
import com.example.puntosalexalberto.login.data.source.LoginRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 *@author Julio Cabrera
 *Created 24/6/2023 at 07:46
 **/


class OkClickLoginUseCase() {
    private val TAG = "LoginUseCase"

    suspend operator fun invoke(user:String, pass:String):Boolean {
        Log.w(TAG, "invoke: ", )
        val loginRepo:ILoginRepo = LoginRepo()
        withContext(Dispatchers.IO){
            loginRepo.login(user,pass)
        }
        return true
    }
}