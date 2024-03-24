    package com.thecodebasecase.io.ui.main.adapter

    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.recyclerview.widget.DiffUtil
    import androidx.recyclerview.widget.ListAdapter
    import com.google.android.material.tabs.TabLayoutMediator
    import com.thecodebasecase.io.databinding.HouseRowItemBinding
    import com.thecodebasecase.io.model.House
    import com.thecodebasecase.io.model.HouseResponse

    interface OnHouseClickListener {
        fun onHouseClick(house: House)
    }

    class HouseAdapter(private val listener: OnHouseClickListener) : ListAdapter<House, HouseViewHolder>(
            object : DiffUtil.ItemCallback<House>() {
                override fun areItemsTheSame(
                    oldItem: House,
                    newItem: House
                ): Boolean {

                    return oldItem == newItem
                }

                override fun areContentsTheSame(
                    oldItem: House,
                    newItem: House
                ): Boolean {
                    return oldItem == newItem
                }
            }
        ) {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): HouseViewHolder {

            return HouseViewHolder(
                HouseRowItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: HouseViewHolder, position: Int) {
            getItem(position).let {
                val houseModel = it
                val isLastItem = position == itemCount - 1

                holder.itemView.setOnClickListener {
                    listener.onHouseClick(houseModel)
                }

                holder.bind(it, isLastItem)
            }
        }
    }
