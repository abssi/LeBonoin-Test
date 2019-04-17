package fr.com.leboncoin.ts.photos

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import fr.com.leboncoin.ts.R
import fr.com.leboncoin.ts.data.Photo
import fr.com.leboncoin.ts.data.PhotoDataSource

class PhotosViewModel(private val repository: PhotoDataSource, private val application: Application)  : ViewModel() {

    var photos = MutableLiveData<MutableList<Photo>>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            photos.postValue(items.toMutableList())
            if (items.isEmpty()) {
                message.set(application.getString(R.string.photo_empty))
            }
            loadingVisibility.set(false)
        }, {
            message.set(application.getString(R.string.photo_failed))
            loadingVisibility.set(false)
        })
    }



}