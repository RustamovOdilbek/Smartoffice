package com.burgutsoft.smartoffice.module.network

import com.burgutsoft.smartoffice.module.service.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val IS_TESTER = false
    private val BASE_URL: String = ""
    private val BASE_URL_DEVELOPMENT: String = ""

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(server())
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private fun server(): String = if (IS_TESTER) BASE_URL_DEVELOPMENT else BASE_URL

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun getClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
//            if (sharedPref.getUserToken(USER_TOKEN, "").isNotEmpty()) {
//                builder.addHeader(
//                    "Authorization",
//                    "Bearer ${sharedPref.getUserToken(USER_TOKEN, "")}"
//                )
//            }
            chain.proceed(builder.build())
        })
        .build()
}


