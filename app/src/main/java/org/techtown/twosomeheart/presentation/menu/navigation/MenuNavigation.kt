package org.techtown.twosomeheart.presentation.menu.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.menu.MenuRoute

fun NavController.navigateMenu(
    navOptions: NavOptions?
) {
    navigate(Menu, navOptions)
}

fun NavGraphBuilder.menuNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Menu> {
        MenuRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
        )
    }
}

@Serializable
data object Menu : Route

