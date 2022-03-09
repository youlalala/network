package org.techtown.network.network

import org.techtown.network.model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object NetWorkService{
    private const val BASE_URL ="https://api.icndb.com/"

    //retrofit 객체 생성
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 서비스 객체 얻기
    val api: APIInterface = retrofit.create(APIInterface::class.java)

}


interface APIInterface{
    @GET("jokes/random/{number}")
    fun test(
            @Path("number") arg: String
    ): Call<Model>
}