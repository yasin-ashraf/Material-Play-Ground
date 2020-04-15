package com.yasin.materialplayground

import android.app.Application
import android.content.Context
import com.yasin.materialplayground.common.dagger.DaggerMainComponent
import com.yasin.materialplayground.common.dagger.MainComponent

/**
 * Created by Yasin on 14/4/20.
 */
class MaterialPlayGround : Application() {

  companion object {
    fun appComponent(context: Context) =
      (context.applicationContext as MaterialPlayGround).mainComponent
  }

  private val mainComponent : MainComponent by lazy {
    DaggerMainComponent.builder()
        .setContext(this.applicationContext)
        .build()
  }

}