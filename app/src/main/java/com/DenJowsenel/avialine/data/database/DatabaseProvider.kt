package com.DenJowsenel.avialine.data.database

import android.content.Context
import androidx.room.Room


object DatabaseProvider {
    private var db: CompaniesDatabase? = null

    fun provideDatabase(context: Context): CompaniesDatabase {
        return db ?: Room.databaseBuilder(
            context.applicationContext,
            CompaniesDatabase::class.java, "company_app_database"
        )
            .build()
            .also{ db = it }
    }
}