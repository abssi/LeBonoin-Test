package fr.com.leboncoin.ts.photos

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import fr.com.leboncoin.ts.data.Photo
import fr.com.leboncoin.ts.databinding.PhotoItemBinding
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import android.content.Context
import com.bumptech.glide.Glide





class PhotosAdapter(var items: List<Photo>) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>(), AdapterItemsContract{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: PhotoItemBinding = PhotoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding,parent.context)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<Photo>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val binding: PhotoItemBinding,val context: Context) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.photo = photo
            Glide.with(context)
                    .load(photo.thumbnailUrl)
                    .apply(RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .centerCrop()
                            .dontTransform())
                    .into(binding.itemRecyclerListImageView)
            binding.itemRecyclerListImageView
            binding.executePendingBindings()
        }
    }
}