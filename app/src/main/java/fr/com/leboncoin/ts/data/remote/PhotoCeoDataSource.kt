package fr.com.leboncoin.ts.data.remote

import fr.com.leboncoin.ts.data.Album
import fr.com.leboncoin.ts.data.Photo
import fr.com.leboncoin.ts.data.PhotoDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoCeoDataSource(val photoApi: PhotoApi) : PhotoDataSource {


    override fun listAll(success: (List<Photo>) -> Unit, failure: () -> Unit) {
        val call = photoApi.listPhotos()
        call.enqueue(object : Callback<List<Photo>> {

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    val photos = mutableListOf<Photo>()
                    response.body()?.forEach {
                        photos.add(it)
                    }
                    success(photos)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable?) {
                failure()
            }
        })

    }
}