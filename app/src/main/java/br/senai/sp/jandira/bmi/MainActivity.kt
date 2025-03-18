package br.senai.sp.jandira.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.bmi.screens.BMIResultScreen
import br.senai.sp.jandira.bmi.screens.TelaInicial
import br.senai.sp.jandira.bmi.screens.UserDataScreen
import br.senai.sp.jandira.bmi.ui.theme.BMITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BMITheme {
               var navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ){
                    composable(
                        route = "home"
                    ){
                        TelaInicial(navController)
                    }
                    composable(
                        route = "user_data"
                    ) {
                        UserDataScreen(navController)
                    }
                    composable(
                        route = "BMIResultScreen"
                    ){
                        BMIResultScreen(navController)
                    }
                }
            }
        }
    }
}


