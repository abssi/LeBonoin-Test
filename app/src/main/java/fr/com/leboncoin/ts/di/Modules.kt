package fr.com.leboncoin.ts.di

import fr.com.leboncoin.ts.photos.PhotosViewModel
import fr.com.leboncoin.ts.data.PhotoDataSource
import fr.com.leboncoin.ts.data.PhotoRepository
import fr.com.leboncoin.ts.data.remote.PhotoApi
import fr.com.leboncoin.ts.data.remote.PhotoCeoDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BreedsModule = module {
    single { Retrofit.Builder().baseUrl("https://static.leboncoin.fr/img/shared/").addConverterFactory(GsonConverterFactory.create()).build() }
    single { (get() as Retrofit).create(PhotoApi::class.java) }

    single  ("api"){PhotoCeoDataSource(get())  as PhotoDataSource }
    single("repository") { PhotoRepository(get("api")) as PhotoDataSource}
    viewModel { PhotosViewModel(get("repository"), androidApplication())}
}


/**
 * Module list
 */
val breedsModule = listOf(BreedsModule)
