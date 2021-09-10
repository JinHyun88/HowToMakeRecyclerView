package com.example.howtomakerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.howtomakerecyclerview.databinding.RowItemBinding

class MainAdapter(val data : ArrayList<Data>, private val onClick:(data : Data, position : Int)->Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    class MainViewHolder(val binding : RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemText = binding.itemText
        val rankText = binding.rankText


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        val holder = MainViewHolder(RowItemBinding.bind(v))

        v.setOnClickListener{
            onClick.invoke(data[holder.adapterPosition], holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.data = data[position]
        holder.rankText.text = data[position].itemRankText
        holder.itemText.text = data[position].itemText
    }

    override fun getItemCount(): Int = data.size
}