package com.example.recicla_app.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.recicla_app.ui.screens.home.HomeScreen
import com.example.recicla_app.ui.screens.login.LoginScreen
import com.example.recicla_app.ui.screens.logout.LogoutScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Logout) {
        composable<Logout> {
            LogoutScreen({ navController.navigate(Login) })
        }
        composable<Login> {
            LoginScreen({ username -> navController.navigate(LoginRequest(username)) })
        }
        composable<LoginRequest> { backStackEntry ->
            val user: LoginRequest = backStackEntry.toRoute()
            HomeScreen(user.username){
                navController.navigate(Logout){
                    popUpTo<Logout>{
                        inclusive = true
                    }
                }
            }
        }
    }
}