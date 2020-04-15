package com.yasin.materialplayground.mergeAdapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yasin.materialplayground.R
import com.yasin.materialplayground.mergeAdapter.model.Post
import kotlinx.android.synthetic.main.list_item_post.view.tv_body
import kotlinx.android.synthetic.main.list_item_post.view.tv_title
import kotlinx.android.synthetic.main.list_item_post.view.tv_user

/**
 * Created by Yasin on 15/4/20.
 */
class PostsAdapter : ListAdapter<Post, PostViewHolder>(PostsAsyncCallBack()) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): PostViewHolder {
    return PostViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_post,parent,false)
    )
  }

  override fun onBindViewHolder(
    holder: PostViewHolder,
    position: Int
  ) {
    val post = currentList[position]
    holder.itemView.tv_title.text = post.title
    holder.itemView.tv_body.text = post.body
    holder.itemView.tv_user.text = post.userId.toString()
  }
}

class PostsAsyncCallBack : DiffUtil.ItemCallback<Post>() {

  override fun areContentsTheSame(
    oldItem: Post,
    newItem: Post
  ): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areItemsTheSame(
    oldItem: Post,
    newItem: Post
  ): Boolean {
    return oldItem == newItem
  }
}

class PostViewHolder(view : View) : RecyclerView.ViewHolder(view)