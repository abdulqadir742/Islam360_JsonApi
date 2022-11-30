package com.example.islam360_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islam360_api.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


const val BASE_URL = "https://api.jsonserve.com/"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var myadapter: MyAdapter
    private var JsonApi = MutableLiveData<List<Post>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }
    fun getData() {
        CoroutineScope(IO).launch {
            var Responce = DataService.Instance.getData()
            var Body = Responce.body()

            withContext(Dispatchers.Main)
            {
                if (Body != null) {
                    JsonApi.postValue(Body.data.posts)
                }

                JsonApi.observe(this@MainActivity, Observer {
                    myadapter = MyAdapter(this@MainActivity, it)
                    binding.recycleViewUser.adapter = myadapter
                    binding.recycleViewUser.layoutManager = LinearLayoutManager(this@MainActivity)
                })

            }

        }


    }

}