package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.UserSettings
import kotlinx.coroutines.flow.Flow

@Dao
interface UserSettingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettings(settings: UserSettings)

    @Query("SELECT * FROM UserSettings WHERE userSettingsId = :id")
    fun getSettingsById(id: Int): Flow<UserSettings?>

    @Query("SELECT * FROM UserSettings")
    fun getAllSettings(): Flow<List<UserSettings>>

    @Update
    suspend fun updateSettings(settings: UserSettings)

    @Delete
    suspend fun deleteSettings(settings: UserSettings)
}
