data class Post(val id: Int, val title: String, val body: String)


interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(ApiService::class.java)