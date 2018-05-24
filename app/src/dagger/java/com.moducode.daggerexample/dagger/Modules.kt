package com.moducode.daggerexample.dagger

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.moducode.daggerexample.room.DbRepo
import com.moducode.daggerexample.room.DbRepoImpl
import com.moducode.daggerexample.room.EpisodeDB
import com.moducode.daggerexample.schedulers.SchedulersBase
import com.moducode.daggerexample.service.EpisodeService
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
class DatabaseModule{

    @Provides
    @Singleton
    fun provideDatabase(context: Context): DbRepo = DbRepoImpl(Room.databaseBuilder(context, EpisodeDB::class.java, "db-episode").build())

}

@Module
class SchedulerModule{

    @Provides
    @Singleton
    fun provideSchedulers(): SchedulersBase = object:SchedulersBase{
        override fun io(): Scheduler = Schedulers.io()

        override fun ui(): Scheduler = AndroidSchedulers.mainThread()

        override fun compute(): Scheduler = Schedulers.computation()
    }

}

@Module(includes = [ContextModule::class])
class RetrofitModule{

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, gson: GsonConverterFactory, callAdapter: RxJava2CallAdapterFactory): Retrofit =
            Retrofit.Builder()
                    .client(httpClient)
                    .addCallAdapterFactory(callAdapter)
                    .baseUrl("http://api.tvmaze.com/")
                    .addConverterFactory(gson)
                    .build()

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: Interceptor, cache: Cache): OkHttpClient =
            OkHttpClient
                    .Builder()
                    .addInterceptor(interceptor)
                    .cache(cache)
                    .build()

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Timber.d(it) })
            .apply { level = HttpLoggingInterceptor.Level.BASIC }


    @Provides
    @Singleton
    fun provideCache(context: Context): Cache = Cache(context.cacheDir, 5 * 1024 * 1024)

    @Provides
    @Singleton
    fun provideRxCallAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

}

@Module
class ContextModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context

}