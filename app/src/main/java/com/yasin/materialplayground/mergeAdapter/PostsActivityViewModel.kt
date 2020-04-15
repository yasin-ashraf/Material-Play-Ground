package com.yasin.materialplayground.mergeAdapter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yasin.materialplayground.mergeAdapter.model.Photo
import com.yasin.materialplayground.mergeAdapter.model.Post
import com.yasin.materialplayground.mergeAdapter.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Yasin on 14/4/20.
 */
class PostsActivityViewModel @Inject constructor(
  private val postsRepository: PostsRepository
) : ViewModel() {
  private val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }
  private val _posts : MutableLiveData<List<Post>> = MutableLiveData()
  val posts : LiveData<List<Post>> = _posts
  private val _users : MutableLiveData<List<User>> = MutableLiveData()
  val users : LiveData<List<User>> = _users
  private val _photos : MutableLiveData<List<Photo>> = MutableLiveData()
  val photos : LiveData<List<Photo>> = _photos

  fun getPosts(userId : Int) {
    compositeDisposable.add(
        postsRepository.getPosts(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              _posts.value = it.take(10)
            },{
              Log.e("Network error - Posts","$it")
            })
    )
  }

  fun getUsers() {
    compositeDisposable.add(
        postsRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              _users.value = it
            },{
              Log.e("Network error - ","$it")
            })
    )
  }

  fun getPhoto() {
    compositeDisposable.add(
        postsRepository.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              _photos.value = it.take(20)
            },{
              Log.e("Network error - ","$it")
            })
    )
  }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.dispose()
  }
}