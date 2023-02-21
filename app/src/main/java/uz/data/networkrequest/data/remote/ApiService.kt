package uz.data.networkrequest.data.remote

import retrofit2.Call
import retrofit2.http.*
import uz.data.networkrequest.model.Post

interface ApiService {
    @Headers("Content-type:application/json; charset=UTF-8")

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

    @GET("posts")
    fun getAllPosts(): Call<ArrayList<Post>>


    @POST("posts")
    fun createPost(@Body() post: Post): Call<Post>

    @PUT("posts/{id}")
    fun editPost(@Path("id") id: Int, @Body() post: Post): Call<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int)
}