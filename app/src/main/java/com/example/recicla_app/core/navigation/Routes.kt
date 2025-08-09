package com.example.recicla_app.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Logout

@Serializable
object Login

@Serializable
data class LoginRequest(val username: String)