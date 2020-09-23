package com.example.coderswag1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag1.R
import com.example.coderswag1.model.Product

class ProductAdapter(val context : Context, val products : List<Product>,val itemClick: (Product) -> Unit): RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_item_list,parent,false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.productName.text = products[position].title
        holder.productPrice.text = products[position].price
        val resourceId = context.resources.getIdentifier(products[position].image,"drawable",context.packageName)
        holder.productImage.setImageResource(resourceId)
        holder.productImage.setOnClickListener { itemClick(products[position]) }

    }

    override fun getItemCount(): Int {
        return products.count()
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage : ImageView = itemView.findViewById(R.id.productItem)
        val productName : TextView = itemView.findViewById(R.id.productName)
        val productPrice : TextView = itemView.findViewById(R.id.productPrice)
    }

}