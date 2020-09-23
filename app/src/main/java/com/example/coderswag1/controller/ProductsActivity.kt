package com.example.coderswag1.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag1.R
import com.example.coderswag1.adapter.ProductAdapter
import com.example.coderswag1.model.Product
import com.example.coderswag1.service.DataService
import com.example.coderswag1.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {
    var category: String = ""
    lateinit var mProductAdapter: ProductAdapter
    lateinit var selectedProducts: List<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        category = intent.getStringExtra(EXTRA_CATEGORY)
        // Toast.makeText(this,"selected text $category",Toast.LENGTH_SHORT).show()
        selectedProducts = DataService.getProduct(category)
        mProductAdapter = ProductAdapter(this, selectedProducts){ selectedProducts->
            val productDetailIntent = Intent(this, ProductDetailsActivity::class.java)
            productDetailIntent.putExtra(EXTRA_CATEGORY, selectedProducts.title)
            startActivity(productDetailIntent)
        }
        productRecycler.adapter = mProductAdapter

        val layoutManager = GridLayoutManager(this, 2)
        productRecycler.layoutManager = layoutManager
        //categoryRecyclerAdapter.setHasFixedSize(true)
    }
}