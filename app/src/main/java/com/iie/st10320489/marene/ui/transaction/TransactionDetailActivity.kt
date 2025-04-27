/*
package com.iie.st10320489.marene.ui.transaction

import com.iie.st10320489.marene.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class TransactionDetailActivity : AppCompatActivity() {
    private lateinit var txtName: TextView
    private lateinit var txtAmount: TextView
    private lateinit var txtMethod: TextView
    private lateinit var txtLocation: TextView
    private lateinit var txtTransactionDate: TextView
    private lateinit var txtDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_transaction_details)

        // Initialize views
        txtName = findViewById(R.id.txtName)
        txtAmount = findViewById(R.id.txtAmount)
        txtMethod = findViewById(R.id.txtMethod)
        txtLocation = findViewById(R.id.txtLocation)
        txtTransactionDate = findViewById(R.id.txtTransactionDate)
        txtDescription = findViewById(R.id.txtDescription)


        // Get TransactionModel from Intent
        val transaction = intent.getParcelableExtra<TransactionModel>("transaction")


        if (transaction != null) {
            txtName.setText(transaction.transactionName)

            val amountText = (if (transaction.isExpense) "-" else "+") + "R" + String.format(
                "%.2f",
                transaction.transactionAmount
            )
            txtAmount.setText(amountText)
            txtMethod.setText(transaction.transactionMethod)
            txtTransactionDate.setText(transaction.transactionDate)
            txtLocation.setText(transaction.transactionLocation)
            txtDescription.setText("HELLO")
        }
    }
}
*/
