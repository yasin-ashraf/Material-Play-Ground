package com.yasin.materialplayground.mergeAdapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Yasin on 14/4/20.
 */
@Singleton
class PostActivityViewModelFactory @Inject constructor(private val postsRepository: PostsRepository) : ViewModelProvider.Factory {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(PostsActivityViewModel::class.java)) {
      return PostsActivityViewModel(postsRepository) as T
    }
    throw IllegalStateException("ViewModel cannot be created!!")
  }
}