# network
retrofit2 + recycler view

https://user-images.githubusercontent.com/62279741/157442052-12230c4a-d358-4198-a64d-c963d67d71d6.mp4



- open api https://api.icndb.com/jokes/random/20 를 활용하여 네트워크 통신하기
- retrofit2 활용 + recycler view 활용
- 객체 클릭시 자세한 내용을 보여주는 Detail Activity 로 전환

#### JSON 
<pre>
<code>
{ "id": 1, "joke": "Joke 1" }, { "id": 5, "joke": "Joke 5" }, { "id": 9, "joke": "Joke 9" } ] }
</code>
</pre>

### 서비스 인터페이스
<pre>
<code>
interface APIInterface{
    @GET("jokes/random/{number}")
    fun test(
            @Path("number") arg: String
    ): Call<Model>
}
</code>
</pre>



### RETROFIT 객체, 서비스 객체
<pre>
<code>
val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
val api: APIInterface = retrofit.create(APIInterface::class.java)
</code>
</pre>

### 모델
<pre>
<code>
data class Model(
        var type: String,
        var value: List<ValueModel>
)
</code>
</pre>
<pre>
<code>
data class ValueModel(
        var id: String,
        var joke: String
)
</code>
</pre>

### 네트워크 통신
<pre>
<code>
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
</code>
</pre>
