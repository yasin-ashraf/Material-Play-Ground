package com.yasin.materialplayground.mergeAdapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yasin.materialplayground.R
import com.yasin.materialplayground.mergeAdapter.model.Photo
import kotlinx.android.synthetic.main.list_item_photo.view.image

/**
 * Created by Yasin on 15/4/20.
 */
class PhotosAdapter : ListAdapter<Photo, PhototViewHolder>(PhotosAsyncCallBack()) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): PhototViewHolder {
    return PhototViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_photo,parent,false)
    )
  }

  override fun onBindViewHolder(
    holder: PhototViewHolder,
    position: Int
  ) {
    val photo = currentList[position]
    Picasso.get()
        .load(photo.url)
        .fit()
        .centerCrop()
        .into(holder.itemView.image)
  }
}

class PhotosAsyncCallBack : DiffUtil.ItemCallback<Photo>() {

  override fun areContentsTheSame(
    oldItem: Photo,
    newItem: Photo
  ): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areItemsTheSame(
    oldItem: Photo,
    newItem: Photo
  ): Boolean {
    return oldItem == newItem
  }
}

class PhototViewHolder(view : View) : RecyclerView.ViewHolder(view)