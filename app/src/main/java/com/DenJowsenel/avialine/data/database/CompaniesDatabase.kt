package com.DenJowsenel.avialine.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.DenJowsenel.avialine.domain.model.Company


@Database(
    entities = [Company::class],
    version = 1
)
abstract class CompaniesDatabase : RoomDatabase() {
    abstract fun CompanyDAO(): CompanyDao
}