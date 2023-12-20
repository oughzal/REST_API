package ma.ofppt.restapi

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id : String) : Post

    @GET("/posts")
    suspend fun getPosts():List<Post>
}