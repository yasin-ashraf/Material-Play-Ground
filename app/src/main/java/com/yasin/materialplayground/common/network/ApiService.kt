package com.yasin.materialplayground.common.network

import com.yasin.materialplayground.mergeAdapter.model.Photo
import com.yasin.materialplayground.mergeAdapter.model.Post
import com.yasin.materialplayground.mergeAdapter.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Yasin on 2/10/19.
 */
interface ApiService {

  @get:GET("photos/")
  val photos: Single<List<Photo>>

  @get:GET("users/")
  val users: Single<List<User>>

  @GET("posts/")
  fun getPosts(): Single<List<Post>>
}
