package com.alom.androidstudy2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alom.androidstudy2.databinding.ItemDataBinding
import com.bumptech.glide.Glide

class ItemListAdapter: ListAdapter<Data, ItemListAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(ItemDataBinding.bind(binding))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val goods = getItem(position)
        holder.bind(goods)
    }

    inner class ViewHolder(private val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(goods: Data) {
            with(binding) {
                Glide.with(root.context)
                    .load(goods.imageUrl)
                    .into(ivGoodsImageItem)
                tvGoodsTitleItem.text = goods.title
                tvGoodsPriceItem.text = goods.price
                tvGoodsTimeItem.text = goods.time
            }
        }
    }
}