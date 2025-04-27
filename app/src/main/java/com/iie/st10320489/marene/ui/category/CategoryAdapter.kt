package com.iie.st10320489.marene.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val categories: List<CategoryModel>,
    private val onCategoryClick: (CategoryModel) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: CategoryModel) {
            binding.categoryTitle.text = category.catTitle
            binding.categoryButton.setImageResource(category.catIcon)
            binding.categoryButton.background.setTint(binding.root.context.getColor(category.catColor))

            // Handle click event
            binding.categoryButton.setOnClickListener {
                onCategoryClick(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount() = categories.size
}
