package org.techtown.twosomeheart.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.techtown.twosomeheart.presentation.detail.navigation.detailNavGraph
import org.techtown.twosomeheart.presentation.dummy.navigation.dummyNavGraph
import org.techtown.twosomeheart.presentation.menu.navigation.menuNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigation = rememberMainNavigator()
) {
    Scaffold(
        content = { paddingValue ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                NavHost(
                    navController = navigator.navController,
                    startDestination = navigator.startDestination
                ) {
                    dummyNavGraph(
                        paddingValues = paddingValue,
                        navigateUp = navigator::navigateUp,
                    )
                    menuNavGraph(
                        paddingValues = paddingValue,
                        navigateUp = navigator::navigateUp,
                    )
                    detailNavGraph(
                        paddingValues = paddingValue,
                        navigateUp = navigator::navigateUp,
                    )
                }
            }
        }
    )
}
