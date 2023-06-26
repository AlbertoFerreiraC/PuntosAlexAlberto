package com.example.puntosalexalberto.login.domain


/**
  *@author Julio Cabrera
  *Create 26/6/2023 at 08:50
  **/
interface ILoginRepo {

    suspend fun login(user:String, pass:String): Boolean

}