package org.techtown.twosomeheart.presentation.mymenu.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.mymenu.MyMenuRoute

fun NavController.navigateMyMenu(
    navOptions: NavOptions?
) {
    navigate(MyMenu, navOptions)
}

fun NavGraphBuilder.myMenuNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<MyMenu> {
        MyMenuRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
        )
    }
}

@Serializable
data object MyMenu : Route