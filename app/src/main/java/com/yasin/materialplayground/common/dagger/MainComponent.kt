package com.yasin.materialplayground.common.dagger

import android.content.Context
import com.yasin.materialplayground.mergeAdapter.PostsActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Yasin on 2/10/19.
 */
@Singleton
@Component(
    modules = [ApplicationModule::class,ContextModule::class,NetworkModule::class,RetrofitModule::class])
interface MainComponent {

     fun inject(postsActivity: PostsActivity)

     @Component.Builder
     interface Builder {
          fun build() : MainComponent
          @BindsInstance fun setContext(@ApplicationContext context: Context) : Builder
     }
}