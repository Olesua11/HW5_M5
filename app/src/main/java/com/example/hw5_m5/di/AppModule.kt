package com.example.hw5_m5.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.hw5_m5.data.local.Pref
import com.example.hw5_m5.LoveApi
import com.example.hw5_m5.room.AppDatabase
import com.example.hw5_m5.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(Pref.PREF_NAME, Context.MODE_PRIVATE)
    }
    @Provides
    fun providePref(sharedPreferences: SharedPreferences): Pref {
        return Pref(sharedPreferences)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun provideDao(appDatabase: AppDatabase): LoveDao {
        return appDatabase.getDao()
    }
}