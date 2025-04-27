package com.iie.st10320489.marene.ui.subcategory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.R


class SubcategoryAdapter(
    private val subcategories: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<SubcategoryAdapter.SubcategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory, parent, false)
        return SubcategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {
        val subcategory = subcategories[position]
        holder.title.text = subcategory
        holder.itemView.setOnClickListener { onItemClick(subcategory) }
    }

    override fun getItemCount(): Int = subcategories.size

    inner class SubcategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.subcategoryTitle)
    }
}
