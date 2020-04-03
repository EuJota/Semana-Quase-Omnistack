package com.example.bethehero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bethehero.Adapter.OngsAdapter
import com.example.bethehero.Controller.RetrofitConfig
import com.example.bethehero.Interface.Ongs
import com.example.bethehero.Model.Ong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OngActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: OngsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ong)

        recyclerView = findViewById(R.id.recyclerview_ongs_list)
        recyclerAdapter = OngsAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        getOngs()
    }



    private fun getOngs() {
        val retrofitConfig = RetrofitConfig
            .getRetrofitConfig("http://192.168.1.4:5000/")

        val ongEndpoint = retrofitConfig.create(Ongs::class.java)
        val callback = ongEndpoint.getOngs()

        callback.enqueue(object : Callback<List<Ong>>{
            override fun onFailure(call: Call<List<Ong>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Ong>>, response: Response<List<Ong>>) {
                if(response?.body() !== null)
                    recyclerAdapter.setOng(response.body()!!)
            }

        })
    }
}
