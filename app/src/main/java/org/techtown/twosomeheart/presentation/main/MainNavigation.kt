package org.techtown.twosomeheart.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.detail.navigation.navigateDetail
import org.techtown.twosomeheart.presentation.menu.navigation.Menu
import org.techtown.twosomeheart.presentation.menu.navigation.navigateMenu
import org.techtown.twosomeheart.presentation.mymenu.navigation.navigateMyMenu
import org.techtown.twosomeheart.presentation.option.navigation.navigateOption

class MainNavigation(
    val navController: NavHostController,
    val startDestination: Route = Menu
) {
    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToMenu(navOptions: NavOptions? = null) {
        navController.navigateMenu(navOptions = navOptions)
    }

    fun navigateToMyMenu(navOptions: NavOptions? = null) {
        navController.navigateMyMenu(navOptions = navOptions)
    }

    fun navigateToDetail(menuId: Long, navOptions: NavOptions? = null) {
        navController.navigateDetail(menuId = menuId, navOptions = navOptions)
    }

    fun navigateToOption(navOptions: NavOptions? = null) {
        navController.navigateOption(navOptions = navOptions)
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigation = remember(navController) {
    MainNavigation(navController)
}
