package fr.com.leboncoin.ts

import android.app.Application
import fr.com.leboncoin.ts.di.breedsModule
import org.koin.android.ext.android.startKoin

class AlbumApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, breedsModule)

    }
}