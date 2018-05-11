package com.moducode.daggerexample.dagger

import android.content.Context
import com.moducode.daggerexample.service.EpisodeService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class EpisodeServiceModule {

    @Provides
    @Singleton
    fun provideEpisodeService(retrofit: Retrofit): EpisodeService = retrofit.create(EpisodeService::class.java)

}

@Module(includes = [ContextModule::class])
class RetrofitModule{

    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .client(httpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("http://api.tvmaze.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides
    fun provideHttpClient(interceptor: Interceptor, cache: Cache): OkHttpClient =
            OkHttpClient
                    .Builder()
                    .addInterceptor(interceptor)
                    .cache(cache)
                    .build()

    @Provides
    fun providesInterceptor(): Interceptor = HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger { Timber.d(it) })
            .apply { level = HttpLoggingInterceptor.Level.BASIC }


    @Provides
    fun provideCache(context: Context): Cache = Cache(context.cacheDir, 5 * 1024 * 1024)

}

@Module
class ContextModule {

    @Provides
    fun provideContext(context: Context): Context = context

}