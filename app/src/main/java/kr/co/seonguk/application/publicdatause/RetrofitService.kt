package kr.co.seonguk.application.publicdatause


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("GGEXPSDLV")
    fun getStoreData(
        @Query("KEY") KEY:String,
        @Query("Type") Type:String
    ): Call<ApiResponse>
}