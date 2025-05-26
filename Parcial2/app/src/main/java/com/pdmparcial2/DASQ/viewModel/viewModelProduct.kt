package com.pdmparcial2.DASQ.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.pdmparcial2.DASQ.data.Producto
import com.pdmparcial2.DASQ.listaRepo.dummyProductos

class ProductViewModel : ViewModel() {

    private val _allProducts = mutableStateListOf<Producto>().apply { addAll(dummyProductos) }
    val allProducts: List<Producto> get() = _allProducts

    var searchQuery by mutableStateOf("")
        private set

    var selectedProduct by mutableStateOf<Producto?>(null)
        private set

    val cartItems: List<Producto>
        get() = _allProducts.filter { it.addedToCart }

    val filteredProducts: List<Producto>
        get() = _allProducts.filter {
            it.name.contains(searchQuery, true) || it.category.contains(searchQuery, true)
        }

    fun onSearchQueryChange(query: String) {
        searchQuery = query
    }

    fun selectProduct(product: Producto) {
        selectedProduct = product
    }

    fun addToCart(product: Producto) {
        _allProducts.replaceAll {
            if (it.id == product.id) it.copy(addedToCart = true) else it
        }
    }
}