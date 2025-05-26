package com.pdmparcial2.DASQ.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.pdmparcial2.DASQ.screens.*
import com.pdmparcial2.DASQ.viewModel.ProductViewModel

sealed class Screens(val route: String) {
    object List : Screens("product_list")
    object Detail : Screens("product_detail")
    object Cart : Screens("cart")
}

@Composable
fun AppNavigator(viewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.List.route) {
        composable(Screens.List.route) {
            ProductListScreen(navController, viewModel)
        }
        composable(Screens.Detail.route) {
            ProductDetailScreen(navController, viewModel)
        }
        composable(Screens.Cart.route) {
            CartScreen(viewModel)
        }
    }
}