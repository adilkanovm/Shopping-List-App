package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entity.ShoppingItem

class ShoppingRepository (val db: ShoppingDatabase) {

    suspend fun upsertItem (item: ShoppingItem) = db.getShoppingDao().upsertItem(item)

    suspend fun deleteItem (item: ShoppingItem) = db.getShoppingDao().deleteItem(item)

    fun getAllShoppingItems () = db.getShoppingDao().getAllShoppingItem()

}