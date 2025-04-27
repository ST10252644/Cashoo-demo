package com.iie.st10320489.marene.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.entities.Transaction

class TransactionAdapter(private var transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.transactionName.text = transaction.name
        holder.transactionAmount.text = "R " + transaction.amount
        holder.transactionDate.text = transaction.dateTime
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    fun updateTransactions(newTransactions: List<Transaction>) {
        transactions = newTransactions
        notifyDataSetChanged()
    }

    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var transactionName: TextView = itemView.findViewById(R.id.title)
        var transactionAmount: TextView = itemView.findViewById(R.id.amount)
        var transactionDate: TextView = itemView.findViewById(R.id.datetime)
    }
}
