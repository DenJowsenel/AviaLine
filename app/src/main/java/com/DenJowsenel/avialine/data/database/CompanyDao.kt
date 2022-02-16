package com.DenJowsenel.avialine.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.DenJowsenel.avialine.domain.model.Company

@Dao
interface CompanyDao {
    @Query("SELECT * FROM company")
    suspend fun getAll(): List<Company>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(companies: List<Company>)
}