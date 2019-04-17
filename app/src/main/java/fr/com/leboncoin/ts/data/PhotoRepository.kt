package fr.com.leboncoin.ts.data

class PhotoRepository(private val dogCeoDataSource: PhotoDataSource) : PhotoDataSource {

    override fun listAll(success: (List<Photo>) -> Unit, failure: () -> Unit) {
        dogCeoDataSource.listAll(success, failure)
    }

}