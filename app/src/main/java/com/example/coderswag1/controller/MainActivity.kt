package com.example.coderswag1.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag1.R
import com.example.coderswag1.adapter.CategoryRecyclerAdapter
import com.example.coderswag1.service.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mCategoryRecyclerAdapter :CategoryRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCategoryRecyclerAdapter = CategoryRecyclerAdapter(this,DataService.categories)
        categoryRecyclerAdapter.adapter = mCategoryRecyclerAdapter

        val layoutManager = LinearLayoutManager(this)
        categoryRecyclerAdapter.layoutManager = layoutManager
        categoryRecyclerAdapter.setHasFixedSize(true)
    }
}