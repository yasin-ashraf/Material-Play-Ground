package com.yasin.materialplayground.materialTransform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.yasin.materialplayground.R

/**
 * Created by Yasin on 30/3/20.
 */
class TaskMotionTransformActivity : AppCompatActivity() {

  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_task_transform)
    init()
  }

  private fun init() {
    val navHostFragment : NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
    navController = navHostFragment.navController
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp()
  }
}