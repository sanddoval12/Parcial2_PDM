package com.pdmparcial2.DASQ

import android.os.Bundle
import androidx.activity.viewModels
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.pdmparcial2.DASQ.navigation.AppNavigator
import com.pdmparcial2.DASQ.ui.theme.Parcial2_PDMTheme
import com.pdmparcial2.DASQ.viewModel.ProductViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val productViewModel: ProductViewModel by viewModels()

        setContent {
            Parcial2_PDMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigator(productViewModel)
                }
            }
        }
    }
}
