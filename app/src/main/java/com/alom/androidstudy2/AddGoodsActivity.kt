package com.alom.androidstudy2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.alom.androidstudy2.databinding.ActivityAddGoodsBinding

class AddGoodsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddGoodsBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = ItemRepositoryImpl()
        val factory = ViewModelFactory(repository)

        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.btnSaveGoods.setOnClickListener{
            val title = binding.etGoodsTitle.text.toString()
            val price = binding.etGoodsPrice.text.toString()
            val time = binding.etGoodsTime.text.toString()

            val item = itemRequest(title, price, time)

            mainViewModel.addValue(item)
        }

        binding.tvBack.setOnClickListener {
            finish()
        }
    }
}