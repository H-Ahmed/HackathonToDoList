package com.example.android.hackathontodolist

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by ahmed on 10/02/2018.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, generatedClassSeparator = "_")
object AppDatabase {
    const val NAME: String = "app"
    const val VERSION: Int = 1
}