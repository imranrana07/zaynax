package com.qcoom.testzaynax.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.qcoom.testzaynax.databinding.ItemDataBinding

class DataViewHolder(itemView: ItemDataBinding): RecyclerView.ViewHolder(itemView.root) {
    val tvNam = itemView.tvNam
    val tvPhone = itemView.tvPhone
    val tvId = itemView.tvId
}
