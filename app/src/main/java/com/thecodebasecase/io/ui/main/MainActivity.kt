package com.thecodebasecase.io.ui.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.thecodebasecase.io.databinding.ActivityMainBinding
import com.thecodebasecase.io.model.House
import com.thecodebasecase.io.ui.base.BaseActivity
import com.thecodebasecase.io.ui.detail.HouseDetailActivity
import com.thecodebasecase.io.ui.main.adapter.HouseAdapter
import com.thecodebasecase.io.ui.main.adapter.OnHouseClickListener
import com.thecodebasecase.io.util.UrlUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var houseAdapter: HouseAdapter

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setupRecyclerView()
        observeViewModel()
        setupSearch()
    }

    private fun setupRecyclerView() {
        houseAdapter = HouseAdapter(object : OnHouseClickListener {
            override fun onHouseClick(house: House) {
                openHouseDetailActivity(house)
            }
        })
        binding.recyclerView.apply {
            adapter = houseAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupSearch() {
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                filterList(s.toString())
            }
        })
    }

    fun filterList(filterItem: String) {
        viewModel.houses.observe(this) { houses ->
            val filteredList = houses.data?.data?.filter {
                it.category!!.contains(filterItem, ignoreCase = true)
            }

            houseAdapter.submitList(filteredList)
        }
    }
    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            showLoading(isLoading)
        }

        viewModel.errorMessages.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }


        viewModel.houses.observe(this) { houses ->
            val newData = ArrayList<House>()

            houses.data?.data?.forEach{ it ->
                val houseModel: House = it
                val imageList = ArrayList<String>()
                it.images.forEach{ img ->
                    if (img != null && UrlUtil.isNotEmpty(img) && UrlUtil.isValidUrl(img)) {
                        imageList.add(img)
                    }
                }

                houseModel.images = imageList
                newData.add(houseModel);
            }

            houseAdapter.submitList(newData)
        }
    }

    private fun openHouseDetailActivity(house: House) {
        val intent = Intent(this, HouseDetailActivity::class.java).apply {
            putExtra("HOUSE_DETAIL", house)
        }
        startActivity(intent)
    }
}