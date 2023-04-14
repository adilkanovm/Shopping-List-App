package com.example.shoppinglist.ui.shoppinglist

import com.example.shoppinglist.data.db.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}