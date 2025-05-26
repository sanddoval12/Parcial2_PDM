package com.pdmparcial2.DASQ.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.pdmparcial2.DASQ.viewModel.ProductViewModel

@Composable
fun ProductDetailScreen(navController: NavController, viewModel: ProductViewModel) {
    val product = viewModel.selectedProduct ?: return

    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(product.image),
            contentDescription = product.name,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(product.name, style = MaterialTheme.typography.headlineSmall)
        Text(product.category)
        Text("S/. ${product.price}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(product.description)

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.addToCart(product)
                navController.popBackStack()
            }
        ) {
            Text("Agregar al carrito")
        }
    }
}