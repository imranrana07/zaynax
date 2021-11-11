package com.qcoom.testzaynax.ui.main.adapter

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.qcoom.testzaynax.data.model.ItemClass
import com.qcoom.testzaynax.databinding.ItemDataBinding
import java.text.SimpleDateFormat
import java.util.*

class DataAdapter: PagingDataAdapter<ItemClass, DataViewHolder>(DiffUtils) {
    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        context = parent.context
        val view = ItemDataBinding.inflate(LayoutInflater.from(context),parent,false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvNam.text = item?.name
        holder.tvPhone.text = item?.phoneNumber
        holder.tvId.text = item?.id
    }

    object DiffUtils : DiffUtil.ItemCallback<ItemClass>() {
        override fun areItemsTheSame(oldItem: ItemClass, newItem: ItemClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemClass, newItem: ItemClass): Boolean {
            return oldItem == newItem
        }
    }

}