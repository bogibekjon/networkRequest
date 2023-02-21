package uz.data.networkrequest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.data.networkrequest.adapter.PostAdapter
import uz.data.networkrequest.data.remote.ApiClient
import uz.data.networkrequest.databinding.ActivityMainBinding
import uz.data.networkrequest.model.Post

class MainActivity : AppCompatActivity() {
    var list = ArrayList<Post>()
    lateinit var adapter: PostAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        getAllPosts()
        binding.apply {
            adapter = PostAdapter(list)
            rvPost.adapter = adapter
            rvPost.layoutManager = GridLayoutManager(this@MainActivity, 1)
        }


    }

    fun getAllPosts() {
        ApiClient.apiService.getAllPosts().enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                if (response.isSuccessful) {
                    list = response.body()!!
                    adapter.submitList(list)
                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}