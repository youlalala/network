package org.techtown.network.network

import org.techtown.network.model.Model
import org.techtown.network.model.ValueModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiWrapper {
    companion object{
        fun getJokeList(callback: (List<ValueModel>)->Unit){
            //call 객체 얻기
            val modelCall = NetWorkService.api.test("20")

            //네트워크 통신
            modelCall.enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    val list = response.body()
                    list?.let{
                        callback.invoke(it.value)
                    }
                }
                override fun onFailure(call: Call<Model>, t: Throwable) {
                    modelCall.cancel()
                }
            })
        }
    }
}