package ma.ofppt.restapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ma.ofppt.restapi.databinding.ActivityMainBinding
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val queue = Volley.newRequestQueue(this)
        binding.btnGet.setOnClickListener {
            val url = "https://jsonplaceholder.typicode.com/posts/" + binding.txtPostId.text.toString()

            val request = StringRequest(Request.Method.GET,url,
                Response.Listener<String> {response ->
                binding.txtResult.text = response
            },
                Response.ErrorListener { error ->
                    binding.txtResult.text = error.message
                }
            )
        queue.add(request)
        }

        binding.btnRetrofit.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}