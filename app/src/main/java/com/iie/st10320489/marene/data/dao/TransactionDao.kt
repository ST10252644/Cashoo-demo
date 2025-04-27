package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM `Transaction` WHERE transactionID = :id")
    fun getTransactionById(id: Int): Flow<Transaction?>

    @Query("SELECT * FROM `Transaction`")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM `Transaction` WHERE (:categoryId IS NULL OR categoryId = :categoryId) AND (:date IS NULL OR dateTime LIKE '%' || :date || '%')")
    fun searchTransactions(categoryId: Int?, date: String?): Flow<List<Transaction>>

    @Insert
    suspend fun insert(transaction: Transaction)

    @Query("SELECT * FROM `Transaction` ORDER BY dateTime DESC LIMIT 2")
    suspend fun getLastTwoTransactions(): List<Transaction>

}


