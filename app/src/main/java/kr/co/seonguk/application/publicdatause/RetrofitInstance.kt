package kr.co.seonguk.application.publicdatause

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {
    const val API_KEY = "032b8fdcd8b348ecbf40a0bea6bc37b2"

    private fun httpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor { message -> Log.e("MyOkHttpClient :", message + "") }
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor())
            .build()
    }


    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .baseUrl("https://openapi.gg.go.kr/")
            .build()
    }

    val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}