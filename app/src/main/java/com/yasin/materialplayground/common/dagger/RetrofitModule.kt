package com.yasin.materialplayground.common.dagger

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.yasin.materialplayground.common.dagger.ApplicationModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Yasin on 10/4/20.
 */
@Module(includes = [ApplicationModule::class])
class RetrofitModule {

  @Provides
  @Singleton
  fun retrofit(
    okHttpClient: OkHttpClient,
    gson: Gson
  ): Retrofit {
    /* INFO: BASE URL FOR APP */
    val baseUrl = POSTS_URL

    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .build()
  }
}