package com.example.mymoviesfinall.ui.theme.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mymoviesfinall.ui.theme.MyMoviesApp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(navController: NavHostController) {
    MyMoviesApp {
        Scaffold(
            topBar = {
                MainAppBar()
            }
        ) { padding ->
            MediaList(navController, Modifier.padding(padding))
        }

    }
}