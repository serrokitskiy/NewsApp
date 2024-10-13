package dev.rokitskiy.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.rokitskiy.newsapp.presentation.screen.LoginScreen
import dev.rokitskiy.newsapp.presentation.screen.MainScreen
import dev.rokitskiy.newsapp.presentation.screen.RegisterScreen
import dev.rokitskiy.newsapp.presentation.screen.viewmodel.LoginScreenViewModel
import kotlinx.serialization.Serializable

sealed class Screen{
    @Serializable
    data object Login: Screen()

    @Serializable
    data object Register: Screen()

    @Serializable
    data object Main: Screen()
}

@Composable
fun MainNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
){
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Login
    ){
        composable<Screen.Login> {
            LoginScreen(
                onNavigateTo = { navigateTo ->
                    navHostController.navigate(navigateTo)
                }
            )

        }
        composable<Screen.Register> {
            RegisterScreen {
                navigateTo ->
                navHostController.navigate(navigateTo)
            }
        }
        composable<Screen.Main> {
            MainScreen {
                navigateTo ->
                navHostController.navigate(navigateTo)
            }
        }
    }
}