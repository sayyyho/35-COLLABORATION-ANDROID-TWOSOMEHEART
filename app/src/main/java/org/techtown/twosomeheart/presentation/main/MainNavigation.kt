package org.techtown.twosomeheart.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.dummy.navigation.Dummy
import org.techtown.twosomeheart.presentation.dummy.navigation.navigateDummy

class MainNavigation(
    val navController: NavHostController,
    val startDestination: Route = Dummy
) {
    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToDummy(navOptions: NavOptions? = null) {
        navController.navigateDummy(navOptions = navOptions)
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigation = remember(navController) {
    MainNavigation(navController)
}
