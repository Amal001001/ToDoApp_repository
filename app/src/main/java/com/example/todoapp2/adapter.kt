package com.example.todoapp2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp2.databinding.ItemRowBinding

class adapter(private val items: ArrayList<todo>): RecyclerView.Adapter<adapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.binding.apply {
            tvItem.text = item.text
            cbItem.isChecked = item.checked

            cbItem.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    tvItem.setTextColor(Color.GRAY)
                }else{
                    tvItem.setTextColor(Color.BLACK)
                }
                item.checked = !item.checked
            }
        }
    }

    override fun getItemCount() = items.size

}