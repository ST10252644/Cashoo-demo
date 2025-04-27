package com.iie.st10320489.marene.data.repository

import com.iie.st10320489.marene.data.dao.*
import com.iie.st10320489.marene.data.entities.*
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    fun getUserById(id: Int): Flow<User?> = userDao.getUserById(id)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
}

class UserSettingsRepository(private val dao: UserSettingsDao) {
    suspend fun insert(settings: UserSettings) = dao.insertSettings(settings)
    fun getAll(): Flow<List<UserSettings>> = dao.getAllSettings()
    fun getById(id: Int): Flow<UserSettings?> = dao.getSettingsById(id)
    suspend fun update(settings: UserSettings) = dao.updateSettings(settings)
    suspend fun delete(settings: UserSettings) = dao.deleteSettings(settings)
}

class TransactionRepository(private val dao: TransactionDao) {
    suspend fun insert(transaction: Transaction) = dao.insertTransaction(transaction)
    fun getAll(): Flow<List<Transaction>> = dao.getAllTransactions()
    fun getById(id: Int): Flow<Transaction?> = dao.getTransactionById(id)
    suspend fun update(transaction: Transaction) = dao.updateTransaction(transaction)
    suspend fun delete(transaction: Transaction) = dao.deleteTransaction(transaction)
    fun searchTransactions(categoryId: Int?, date: String?): Flow<List<Transaction>> {
        return dao.searchTransactions(categoryId, date)
    }

}

class CategoryRepository(private val dao: CategoryDao) {
    suspend fun insert(category: Category) = dao.insertCategory(category)
    fun getAll(): Flow<List<Category>> = dao.getAllCategories()
    fun getById(id: Int): Flow<Category?> = dao.getCategoryById(id)
    suspend fun delete(category: Category) = dao.deleteCategory(category)
}

class SubCategoryRepository(private val dao: SubCategoryDao) {
    suspend fun insert(subCategory: SubCategory) = dao.insertSubCategory(subCategory)
    fun getAll(): Flow<List<SubCategory>> = dao.getAllSubCategories()
    fun getById(id: Int): Flow<SubCategory?> = dao.getSubCategoryById(id)
    suspend fun delete(subCategory: SubCategory) = dao.deleteSubCategory(subCategory)
}

class RewardRepository(private val dao: RewardDao) {
    suspend fun insert(reward: Reward) = dao.insertReward(reward)
    fun getAll(): Flow<List<Reward>> = dao.getAllRewards()
    fun getById(id: Int): Flow<Reward?> = dao.getRewardById(id)
    suspend fun update(reward: Reward) = dao.updateReward(reward)
    suspend fun delete(reward: Reward) = dao.deleteReward(reward)
}

class RewardHistoryRepository(private val dao: RewardHistoryDao) {
    suspend fun insert(history: RewardHistory) = dao.insertHistory(history)
    fun getAll(): Flow<List<RewardHistory>> = dao.getAllHistory()
    fun getById(id: Int): Flow<RewardHistory?> = dao.getHistoryById(id)
    suspend fun delete(history: RewardHistory) = dao.deleteHistory(history)
}

class ActivityLogRepository(private val dao: ActivityLogDao) {
    suspend fun insert(log: ActivityLog) = dao.insertLog(log)
    fun getAll(): Flow<List<ActivityLog>> = dao.getAllLogs()
    fun getById(id: Int): Flow<ActivityLog?> = dao.getLogById(id)
    suspend fun delete(log: ActivityLog) = dao.deleteLog(log)
}