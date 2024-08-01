package com.martinestudio.kidsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martinestudio.kidsapp.databinding.HistroyitemBinding
import com.martinestudio.kidsapp.model.HistoryModelClass


class HistoryAdapter(private var listHistory:ArrayList<HistoryModelClass>):RecyclerView.Adapter<HistoryAdapter.HistoryCoinViewHolder>() {
    class HistoryCoinViewHolder(var binding: HistroyitemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryCoinViewHolder {
        return HistoryCoinViewHolder(HistroyitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun getItemCount(): Int {
        return listHistory.size
    }

    override fun onBindViewHolder(holder: HistoryCoinViewHolder, position: Int) {
        holder.binding.coinValueText.text = listHistory[position].coin
        holder.binding.dateTimeText.text = listHistory[position].timeAndDate

    }
}
