package org.techtown.twosomeheart.presentation.option.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.techtown.twosomeheart.core.Route
import org.techtown.twosomeheart.presentation.option.OptionRoute

fun NavController.navigateOption(
    navOptions: NavOptions?
) {
    navigate(Option, navOptions)
}

fun NavGraphBuilder.optionNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Option> {
        OptionRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
        )
    }
}

@Serializable
data object Option : Route
