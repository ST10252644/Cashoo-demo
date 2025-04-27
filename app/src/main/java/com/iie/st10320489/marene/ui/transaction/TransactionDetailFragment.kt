package com.iie.st10320489.marene.ui.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.iie.st10320489.marene.R

class TransactionDetailFragment : Fragment() {
    private lateinit var txtName: TextView
    private lateinit var txtAmount: TextView
    private lateinit var txtMethod: TextView
    private lateinit var txtLocation: TextView
    private lateinit var txtTransactionDate: TextView
    private lateinit var txtDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transaction_details, container, false)

        // Initialize views
        txtName = view.findViewById(R.id.txtName)
        txtAmount = view.findViewById(R.id.txtAmount)
        txtMethod = view.findViewById(R.id.txtMethod)
        txtLocation = view.findViewById(R.id.txtLocation)
        txtTransactionDate = view.findViewById(R.id.txtTransactionDate)
        txtDescription = view.findViewById(R.id.txtDescription)

        // Retrieve transaction from arguments
        val transaction = arguments?.getParcelable<TransactionModel>("transaction")

        transaction?.let {
            txtName.text = it.transactionName

            val amountText = (if (it.isExpense) "-" else "+") + "R" + String.format("%.2f", it.transactionAmount)
            txtAmount.text = amountText

            txtMethod.text = it.transactionMethod
            txtTransactionDate.text = it.transactionDate

            // Optional placeholder data
            txtLocation.text = it.transactionLocation
            txtDescription.text = it.transactionDescription
        }

        return view
    }
}
