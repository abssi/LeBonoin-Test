package fr.com.leboncoin.ts

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import fr.com.leboncoin.ts.photos.AdapterItemsContract

class BindingAdapters {

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, items: MutableList<Any>) {

            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    it.replaceItems(items)
                }
            }
        }
    }

}