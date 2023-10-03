package com.example.mymoviesfinall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymoviesfinall.ui.theme.screens.main.MainScreen
import com.example.mymoviesfinall.ui.theme.screens.details.DetailScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Para navegar se necesita el navcontroller
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(navController)
                        }
                        composable("detail"){
                            DetailScreen()
                        }
                }
            }
        }


}









