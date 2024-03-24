    package com.thecodebasecase.io.ui.main.adapter

    import android.view.View
    import androidx.recyclerview.widget.RecyclerView
    import com.google.android.material.tabs.TabLayoutMediator
    import com.thecodebasecase.io.databinding.HouseRowItemBinding
    import com.thecodebasecase.io.model.House

    class HouseViewHolder(
        private val binding: HouseRowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: House, isLastItem: Boolean) {
            binding.apply {
                val adapter = HouseSliderAdapter(data.images)
                binding.viewPagerSlider.adapter = adapter
                binding.viewPagerTabLayout.setViewPager2(binding.viewPagerSlider)

                binding.location.text = "${data.city} / ${data.district} / ${data.neighborhood}"
                binding.date.text = data.createdDate
                binding.category.text = data.category
                binding.bedrooms.text = "${data.room} oda"
                binding.bathrooms.text = "${data.bathCount} banyo"
                binding.squareMeters.text = "${data.gross} brüt m² ${data.net} net m2"
                binding.divider.visibility = if (isLastItem) View.GONE else View.VISIBLE

                if (data.label == null) {
                    binding.newLabel.visibility = View.GONE
                } else {
                    binding.newLabel.text = data.label
                }
            }
        }
    }
