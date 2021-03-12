package com.foreach.android.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.foreach.android.di.viewModelModule
import com.foreach.data.di.apiModule
import com.foreach.data.di.databaseModule
import com.foreach.data.di.repositoryModule
import com.foreach.domain.di.interactorModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        context = this
        Stetho.initializeWithDefaults(this)

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(modules)
        }
    }
    private val modules = listOf(
        viewModelModule,
        databaseModule,
        apiModule,
        repositoryModule,
        interactorModule,
    )

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var mInstance: App

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context


        @Synchronized
        fun getInstance(): App {
            return mInstance
        }
    }
}