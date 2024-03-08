package com.example.hw5_m5.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw5_m5.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(lioveModel: LoveModel)
    @Query ("SELECT * FROM `love-table` ORDER BY fname ASC")
    fun getAll(): LiveData<LoveModel>
}