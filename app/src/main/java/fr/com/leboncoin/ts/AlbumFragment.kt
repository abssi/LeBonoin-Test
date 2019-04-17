package fr.com.leboncoin.ts

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.com.leboncoin.ts.photos.PhotosAdapter
import fr.com.leboncoin.ts.photos.PhotosViewModel
import fr.com.leboncoin.ts.data.Photo
import fr.com.leboncoin.ts.databinding.AlbumFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel


class AlbumFragment : Fragment() {

    val vm: PhotosViewModel by viewModel()

    companion object {
        fun newInstance(): AlbumFragment {
            return AlbumFragment()
        }
    }

    override fun onStart() {
        super.onStart()
        vm.load()
    }

    override fun onCreateView(@NonNull inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : AlbumFragmentBinding = AlbumFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        binding.recyclerView.adapter = PhotosAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        val observer =  object : Observer<MutableList<Photo>> {
            override fun onChanged(t: MutableList<Photo>?) {
                BindingAdapters.setItems(binding.recyclerView, t!!.toMutableList())
            }

        }
        vm.photos.observe(this, observer)

        return binding.root
    }

}


