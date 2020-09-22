package com.example.coderswag1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag1.R
import com.example.coderswag1.controller.ProductsActivity
import com.example.coderswag1.model.Category
import com.example.coderswag1.utilities.EXTRA_CATEGORY

class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.category_layout_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position].title
        val resourceId = context.resources.getIdentifier(categories[position].image,"drawable",context.packageName)
        holder.categoryImage.setImageResource(resourceId)
        holder.categoryImage.setOnClickListener(View.OnClickListener {
            val productIntent = Intent(context, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, categories[position].title)
            context.startActivity(productIntent)
        })
    }

    override fun getItemCount(): Int {
        return categories.count()
    }


    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTitle = itemView.findViewById<TextView>(R.id.categoryTitle)
        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)

    }
}
