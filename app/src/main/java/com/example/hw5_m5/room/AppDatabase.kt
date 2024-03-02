package com.example.hw5_m5.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw5_m5.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao():LoveDao
}