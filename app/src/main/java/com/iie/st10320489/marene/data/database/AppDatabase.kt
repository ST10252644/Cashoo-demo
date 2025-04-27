package com.iie.st10320489.marene.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iie.st10320489.marene.data.dao.*
import com.iie.st10320489.marene.data.entities.*

@Database(
    entities = [
        User::class,
        UserSettings::class,
        Transaction::class,
        Category::class,
        SubCategory::class,
        Reward::class,
        RewardHistory::class,
        ActivityLog::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun userSettingsDao(): UserSettingsDao
    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
    abstract fun subCategoryDao(): SubCategoryDao
    abstract fun rewardDao(): RewardDao
    abstract fun rewardHistoryDao(): RewardHistoryDao
    abstract fun activityLogDao(): ActivityLogDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/myapp.db")  // Reference to the prepopulated database
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
