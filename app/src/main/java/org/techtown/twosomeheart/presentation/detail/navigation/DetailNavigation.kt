package org.techtown.twosomeheart.presentation.detail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.detail.DetailRoute

fun NavController.navigateDetail(
    navOptions: NavOptions?,
    menuId: Long
) {
    navigate(
        Detail(
            menuId = menuId
        ),
        navOptions
    )
}

fun NavGraphBuilder.detailNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Detail> { backStackEntry ->
        val menuId = backStackEntry.toRoute<Detail>()
        DetailRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            menuId = menuId.menuId
        )
    }
}

@Serializable
data class Detail(
    val menuId: Long
) : Route
