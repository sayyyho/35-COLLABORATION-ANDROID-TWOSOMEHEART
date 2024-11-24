package org.techtown.twosomeheart.presentation.detail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.detail.DetailRoute

fun NavController.navigateDetail(
    navOptions: NavOptions?
) {
    navigate(Detail, navOptions)
}

fun NavGraphBuilder.detailNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Detail> {
        DetailRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
        )
    }
}

@Serializable
data object Detail : Route