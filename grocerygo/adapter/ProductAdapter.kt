package com.example.grocerygo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerygo.data.model.Product
import com.example.grocerygo.databinding.ItemProductBinding
import com.example.grocerygo.utils.CartManager


class ProductAdapter(
    private var productList: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {

        val product = productList[position]

        holder.binding.tvName.text =
            product.name

        holder.binding.tvPrice.text =
            "₹${product.price}"

        holder.binding.ivProduct.setImageResource(
            product.image
        )

        holder.binding.btnAdd.setOnClickListener {

            CartManager.addToCart(product)

            Toast.makeText(
                holder.itemView.context,
                "✅ ${product.name} Added To Cart",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount() = productList.size

    // UPDATE LIST FOR SEARCH
    fun updateList(newList: List<Product>) {

        productList = newList

        notifyDataSetChanged()
    }
}