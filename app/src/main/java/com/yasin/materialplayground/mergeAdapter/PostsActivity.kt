package com.yasin.materialplayground.mergeAdapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yasin.materialplayground.MaterialPlayGround
import com.yasin.materialplayground.R
import com.yasin.materialplayground.mergeAdapter.adapter.PhotosAdapter
import com.yasin.materialplayground.mergeAdapter.adapter.PostsAdapter
import com.yasin.materialplayground.mergeAdapter.adapter.UsersAdapter
import kotlinx.android.synthetic.main.activity_merge_adapter.rv_posts
import javax.inject.Inject

/**
 * Created by Yasin on 14/4/20.
 */
class PostsActivity : AppCompatActivity() {

  @Inject lateinit var postActivityViewModelFactory: PostActivityViewModelFactory
  private lateinit var postsActivityViewModel: PostsActivityViewModel
  private lateinit var mergeAdapter: MergeAdapter
  private val usersAdapter : UsersAdapter by lazy { UsersAdapter() }
  private val postsAdapter : PostsAdapter by lazy { PostsAdapter() }
  private val photosAdapter : PhotosAdapter by lazy { PhotosAdapter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    MaterialPlayGround.appComponent(this).inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_merge_adapter)
    configureViewModel()
    init()
    observeData()
  }

  private fun configureViewModel() {
    postsActivityViewModel = ViewModelProvider(
        this,
        postActivityViewModelFactory
    )[PostsActivityViewModel::class.java]
  }

  private fun observeData() {
    postsActivityViewModel.posts.observe(this, Observer {
      postsAdapter.submitList(it)
    })
    postsActivityViewModel.users.observe(this, Observer {
      usersAdapter.submitList(it)
    })
    postsActivityViewModel.photos.observe(this, Observer {
      photosAdapter.submitList(it)
    })
  }

  private fun init() {
    val adapterList : MutableList<RecyclerView.Adapter<out RecyclerView.ViewHolder>> = mutableListOf(usersAdapter)
    adapterList.add(postsAdapter)
    adapterList.add(photosAdapter) //rendered in sequence
    mergeAdapter = MergeAdapter(adapterList)
    rv_posts.adapter = mergeAdapter
    postsActivityViewModel.getUsers()
    postsActivityViewModel.getPhoto()
    postsActivityViewModel.getPosts(2)
  }

}