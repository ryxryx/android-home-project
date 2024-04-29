package com.example.androidhomeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.androidhomeproject.ui.MovieList
import com.example.androidhomeproject.ui.MovieDetail
import com.example.androidhomeproject.ui.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.MovieList.route){
                composable(Screen.MovieList.route){
                    MovieList(navController)
                }
                composable(Screen.MovieDetail.route){
                    MovieDetail(navController)
                }
            }
        }
    }
}
