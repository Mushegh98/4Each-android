package com.foreach.data.di

import android.app.Application
import androidx.room.Room
import com.foreach.data.dataservice.sqlservice.AppDatabase
import com.foreach.data.dataservice.appservice.PreferenceService
import com.foreach.data.dataservice.appservice.PreferenceServiceImpl
import com.foreach.data.dataservice.RetrofitService

import com.foreach.data.utils.Constants.Companion.MAIN_URL
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.foreach.data.datastore.SettingsRepository
import com.foreach.data.datastore.StartFragmentRepository
import com.foreach.data.datastore.ThemesRepository
import com.foreach.data.repository.SettingsRepositoryImpl
import com.foreach.data.repository.StartFragmentRepositoryImpl
import com.foreach.data.repository.ThemesRepositoryImpl
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { Moshi.Builder().build() }

    single<Retrofit> {
        Retrofit.Builder()
                .baseUrl(MAIN_URL)
//                .addConverterFactory(MoshiConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .apply {
                    client(
                            OkHttpClient.Builder()
                                    .addInterceptor { chain ->
                                        val request = chain.request()
                                        val response = chain.proceed(request)
                                        response
                                    }
                                    .addNetworkInterceptor(StethoInterceptor())
                                    .addInterceptor(HttpLoggingInterceptor().apply {
                                        level = HttpLoggingInterceptor.Level.BODY
                                    })
                                    .build()
                    )
                }
                .build()
    }

    single<RetrofitService> { get<Retrofit>().create(RetrofitService::class.java) }

}
val databaseModule = module {
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "GameDB")
                 .fallbackToDestructiveMigration()
//                .allowMainThreadQueries()
                .build()
    }
    single { provideDatabase(androidApplication()) }
    single { get<AppDatabase>().roomDao() }

}

val repositoryModule = module {

    /**Services**/
    single<PreferenceService> { PreferenceServiceImpl(get()) }



    /**Repositorys**/
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
    single<ThemesRepository> { ThemesRepositoryImpl(get()) }
    single<StartFragmentRepository> { StartFragmentRepositoryImpl(get(),get()) }
}


