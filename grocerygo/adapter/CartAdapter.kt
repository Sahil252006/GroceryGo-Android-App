package com.example.grocerygo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerygo.data.model.CartItem
import com.example.grocerygo.databinding.ItemCartBinding
import com.example.grocerygo.utils.CartManager

class CartAdapter(
    private val cartList: MutableList<CartItem>,
    private val onCartUpdated: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(
        val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {

        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {

        val item = cartList[position]

        holder.binding.tvCartName.text =
            item.product.name

        holder.binding.tvCartPrice.text =
            "₹${item.product.price}"

        holder.binding.tvQuantity.text =
            item.quantity.toString()

        holder.binding.ivCartProduct.setImageResource(
            item.product.image
        )

        // PLUS BUTTON
        holder.binding.btnPlus.setOnClickListener {

            item.quantity++

            notifyItemChanged(position)

            onCartUpdated()
        }

        // MINUS BUTTON
        holder.binding.btnMinus.setOnClickListener {

            if (item.quantity > 1) {

                item.quantity--

                notifyItemChanged(position)

                onCartUpdated()
            }
        }

        // REMOVE BUTTON
        holder.binding.btnRemove.setOnClickListener {

            cartList.removeAt(position)

            notifyItemRemoved(position)

            notifyDataSetChanged()

            onCartUpdated()
        }
    }

    override fun getItemCount() = cartList.size
}