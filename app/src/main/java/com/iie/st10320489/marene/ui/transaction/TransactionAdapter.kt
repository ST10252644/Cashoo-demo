package com.iie.st10320489.marene.ui.transaction

import com.iie.st10320489.marene.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.databinding.ItemTransactionBinding


class TransactionAdapter(
    private val transactions: List<TransactionModel>,
    private val onItemClick: (TransactionModel) -> Unit
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(private val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: TransactionModel) {
            binding.txtTransactionName.text = transaction.transactionName
            binding.txtTransactionMethod.text = transaction.transactionMethod
            binding.txtTransactionDate.text = transaction.transactionDate
            setTransactionAmount(transaction)

            // Set icon and background color
            binding.imgCategoryIcon.setImageResource(transaction.transactionIcon)
            binding.imgCategoryIconBackground.background.setTint(
                binding.root.context.getColor(transaction.transactionColor)
            )

            // Handle click event
            binding.root.setOnClickListener {
                onItemClick(transaction)
            }
        }

        private fun setTransactionAmount(transaction: TransactionModel) {
            if (transaction.isExpense) {
                binding.txtTransactionAmount.text = String.format("-R%.2f", transaction.transactionAmount)
                binding.txtTransactionAmount.setTextColor(
                    ContextCompat.getColor(binding.root.context, R.color.outcome)
                )
            } else {
                binding.txtTransactionAmount.text = String.format("+R%.2f", transaction.transactionAmount)
                binding.txtTransactionAmount.setTextColor(
                    ContextCompat.getColor(binding.root.context, R.color.income)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding =
            ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}
