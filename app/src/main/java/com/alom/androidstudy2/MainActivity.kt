package com.alom.androidstudy2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.alom.androidstudy2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private val itemAdapter by lazy { ItemListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = ItemRepositoryImpl()
        val factory = ViewModelFactory(repository)

        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.rvItems.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = itemAdapter
        }

        binding.tvAdd.setOnClickListener{
            val intent = Intent(this, AddGoodsActivity::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch {
            mainViewModel.currentData.collect { dataList ->
                itemAdapter.submitList(dataList)
            }
        }

        mainViewModel.updateValue()
    }
}