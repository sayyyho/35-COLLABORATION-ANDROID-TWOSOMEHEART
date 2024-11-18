package org.techtown.twosomeheart.presentation.dummy.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.dummy.DummyRoute

fun NavController.navigateDummy(
    navOptions: NavOptions?
) {
    navigate(Dummy, navOptions)
}

fun NavGraphBuilder.dummyNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Dummy> {
        DummyRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
        )
    }
}

@Serializable
data object Dummy : Route
