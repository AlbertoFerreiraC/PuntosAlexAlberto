package com.example.puntosalexalberto.login.domain

interface ILoginRepo {
    suspend fun login(user: String, pass: String): Boolean
}