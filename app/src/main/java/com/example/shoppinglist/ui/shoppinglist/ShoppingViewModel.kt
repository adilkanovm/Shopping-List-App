package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.db.entity.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel(){
    fun upsertItem(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsertItem(item)
    }

    fun deleteItem(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteItem(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}