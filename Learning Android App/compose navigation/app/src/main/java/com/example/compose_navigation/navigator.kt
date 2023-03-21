package com.example.compose_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object navigator {

    @Provides
    @Composable
    @Singleton
    fun provideNavigationController(): NavHostController {
        return rememberNavController()
    }

}