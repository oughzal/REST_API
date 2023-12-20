package ma.ofppt.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ma.ofppt.restapi.databinding.ActivityMain2Binding
import ma.ofppt.restapi.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MainActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGet.setOnClickListener {
            val id= binding.txtPostId.text.toString()
            GlobalScope.launch(Dispatchers.Main) {
                val url ="https://jsonplaceholder.typicode.com"
                val retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()


                val postApi = retrofit.create(PostService::class.java)

                val post = postApi.getPost(id)
                val postList = postApi.getPosts()
                binding.txtResult.text = post.toString()
            }


        }
    }
}