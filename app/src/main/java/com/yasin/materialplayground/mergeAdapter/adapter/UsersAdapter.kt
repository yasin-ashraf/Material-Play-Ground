package com.yasin.materialplayground.mergeAdapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yasin.materialplayground.R
import com.yasin.materialplayground.mergeAdapter.model.User
import kotlinx.android.synthetic.main.list_item_user.view.tv_company
import kotlinx.android.synthetic.main.list_item_user.view.tv_email
import kotlinx.android.synthetic.main.list_item_user.view.tv_phone
import kotlinx.android.synthetic.main.list_item_user.view.tv_userName

/**
 * Created by Yasin on 14/4/20.
 */
class UsersAdapter : ListAdapter<User,UserViewHolder>(UserAsyncCallBack()) {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): UserViewHolder {
    return UserViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_user,parent,false)
    )
  }

  override fun onBindViewHolder(
    holder: UserViewHolder,
    position: Int
  ) {
    val user = currentList[position]
    holder.itemView.tv_userName.text = user.name
    holder.itemView.tv_phone.text = user.phone
    holder.itemView.tv_email.text = user.email
    holder.itemView.tv_company.text = user.company.name
  }
}

class UserAsyncCallBack : DiffUtil.ItemCallback<User>() {
  override fun areItemsTheSame(
    oldItem: User,
    newItem: User
  ): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(
    oldItem: User,
    newItem: User
  ): Boolean {
    return oldItem == newItem
  }
}

class UserViewHolder(view : View) : RecyclerView.ViewHolder(view)