package com.thecodebasecase.io.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.thecodebasecase.io.databinding.HouseDetailActivityBinding
import com.thecodebasecase.io.model.House
import com.thecodebasecase.io.ui.base.BaseActivity
import com.thecodebasecase.io.ui.detail.adapter.HouseDetailAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HouseDetailActivity : BaseActivity() {
    private lateinit var binding: HouseDetailActivityBinding
    private lateinit var houseDetailAdapter: HouseDetailAdapter

    private val viewModel: HouseDetailActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HouseDetailActivityBinding.inflate(layoutInflater)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        setContentView(binding.root)
        observeViewModel()
    }

    private fun observeViewModel() {
        val house = intent.getParcelableExtra<House>("HOUSE_DETAIL")
        house?.let {
            viewModel.setHouseDetail(it)

            val imageUrl = house.images[0]

            Glide.with(this)
                .load(imageUrl)
                .into(binding.imageViewBackground)

            houseDetailAdapter = HouseDetailAdapter(it)
            binding.recyclerView.apply {
                adapter = houseDetailAdapter
                layoutManager = LinearLayoutManager(this@HouseDetailActivity)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}