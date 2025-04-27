package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE userID = :id")
    fun getUserById(id: Int): Flow<User?>

    @Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<User>>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
