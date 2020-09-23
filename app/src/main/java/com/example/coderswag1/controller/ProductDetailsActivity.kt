package com.example.coderswag1.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coderswag1.R
import com.example.coderswag1.utilities.EXTRA_CATEGORY
import android.content.Intent

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
       val productDetail = intent.getStringExtra(EXTRA_CATEGORY)
        Toast.makeText(this,"selected text $productDetail",Toast.LENGTH_SHORT).show()
    }
}