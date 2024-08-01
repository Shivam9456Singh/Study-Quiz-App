package com.martinestudio.kidsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.martinestudio.kidsapp.QuizActivity
import com.martinestudio.kidsapp.databinding.CategoryitemBinding
import com.martinestudio.kidsapp.model.categoryModelClass

class categoryadapter(
    var categoryList: ArrayList<categoryModelClass>,
    var requireActivity: FragmentActivity,
) : RecyclerView.Adapter<categoryadapter.MycategoryViewHolder>() {
    class MycategoryViewHolder(var binding: CategoryitemBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MycategoryViewHolder {
        return MycategoryViewHolder(
            CategoryitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = categoryList.size

    override fun onBindViewHolder(holder: MycategoryViewHolder, position: Int) {
        var dataList = categoryList[position]
        holder.binding.categoryImage.setImageResource(dataList.catImage)
        holder.binding.category.text = dataList.catText
        holder.binding.categoryButton.setOnClickListener {
            var intent = Intent(requireActivity, QuizActivity::class.java)
            intent.putExtra("categoryimg", dataList.catImage)
            requireActivity.startActivity(intent)
        }
    }
}