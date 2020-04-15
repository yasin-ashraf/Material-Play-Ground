package com.yasin.materialplayground.common.dagger

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yasin.materialplayground.common.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Yasin on 2/10/19.
 */
@Module(includes = [NetworkModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun apiServices(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(
            ApiService::class.java)
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
        return gsonBuilder.create()
    }

   /* @Provides
    @Singleton
    fun sessionManager(@ApplicationContext context: Context): SessionManager {
        return SessionManager(context)
    }*/

}
