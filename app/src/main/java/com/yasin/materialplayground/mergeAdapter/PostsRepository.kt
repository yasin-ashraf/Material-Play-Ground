package com.yasin.materialplayground.mergeAdapter

import com.yasin.materialplayground.common.network.ApiService
import com.yasin.materialplayground.mergeAdapter.model.Photo
import com.yasin.materialplayground.mergeAdapter.model.Post
import com.yasin.materialplayground.mergeAdapter.model.User
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Yasin on 14/4/20.
 */
class PostsRepository @Inject constructor(
  private val apiService: ApiService
) {

  fun getPosts(userId : Int) : Single<List<Post>> = apiService.getPosts()

  fun getUsers() : Single<List<User>> = apiService.users

  fun getPhotos() : Single<List<Photo>> = apiService.photos
}