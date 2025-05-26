package com.pdmparcial2.DASQ.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pdmparcial2.DASQ.viewModel.ProductViewModel

@Composable
fun CartScreen(viewModel: ProductViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Carrito", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(viewModel.cartItems.size) { index ->
                val product = viewModel.cartItems[index]
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(product.image),
                            contentDescription = product.name,
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(product.name)
                            Text("S/. ${product.price}")
                        }
                    }
                }
            }
        }
    }
}