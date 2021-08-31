package com.divyanshu.mvvmpractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun initRecyclerView() {
        rlv_data_list.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        rlv_data_list.adapter = recyclerViewAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this,
            {
                if (it != null) {
                    recyclerViewAdapter.setUpdatedData(it.items)
                    recyclerViewAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@MainActivity, "Error getting the data", Toast.LENGTH_SHORT)
                        .show()
                }

                viewModel.makeAPICall()
            })

    }
}