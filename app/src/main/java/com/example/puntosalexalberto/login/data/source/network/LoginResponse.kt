package com.example.puntosalexalberto.login.data.source.network

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expires_in")
    val expiresIn: Long,
    @SerializedName("refresh_expires_in")
    val refreshExpiresIn: Long,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("not-before-policy")
    val notBeforePolicy: String,
    @SerializedName("session_state")
    val sessionState: String,
    @SerializedName("scope")
    val scope: String
)
