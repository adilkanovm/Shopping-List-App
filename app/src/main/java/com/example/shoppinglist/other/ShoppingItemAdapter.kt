package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entity.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = items[position]
        val name = holder.itemView.findViewById<TextView>(R.id.tvName)
        val amount = holder.itemView.findViewById<TextView>(R.id.tvAmount)
        val plus = holder.itemView.findViewById<ImageView>(R.id.ivPlus)
        val minus = holder.itemView.findViewById<ImageView>(R.id.ivMinus)
        val delete = holder.itemView.findViewById<ImageView>(R.id.ivDelete)
        name.text = currentItem.name
        amount.text = "${currentItem.amount}"

        delete.setOnClickListener {
            viewModel.deleteItem(currentItem)
        }
        plus.setOnClickListener {
            currentItem.amount++
            viewModel.upsertItem(currentItem)
        }
        minus.setOnClickListener {
            if (currentItem.amount > 0) {
                currentItem.amount--
                viewModel.upsertItem(currentItem)
            }
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }
}