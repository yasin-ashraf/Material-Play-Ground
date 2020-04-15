package com.yasin.materialplayground.common.dagger

import android.content.Context


import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Yasin on 2/10/19.
 */
@Module
class ContextModule {

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context) = context
}
