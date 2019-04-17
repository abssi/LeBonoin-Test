package fr.com.leboncoin.ts.data

interface PhotoDataSource {

    fun listAll(success : (List<Photo>) -> Unit, failure: () -> Unit)
}