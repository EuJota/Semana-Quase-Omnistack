package com.example.bethehero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bethehero.Adapter.IncidentsAdapter
import com.example.bethehero.Controller.RetrofitConfig
import com.example.bethehero.Interface.Incidents
import com.example.bethehero.Model.Incident
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: IncidentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(false)

        recyclerView = findViewById(R.id.recyclerview_incidents_list)
        recyclerAdapter = IncidentsAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        getIncidents()


    }

    fun getIncidents() {
        val retrofitConfig = RetrofitConfig
            .getRetrofitConfig("http://192.168.1.4:5000/")

        val incidentsEndpoint = retrofitConfig.create(Incidents::class.java)
        val callback = incidentsEndpoint.getIncidents()

        callback.enqueue(object : Callback<List<Incident>>{
            override fun onFailure(call: Call<List<Incident>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Incident>>, response: Response<List<Incident>>) {
                if(response?.body() !==null)
                    recyclerAdapter.setIncidentsList(response.body()!!)
            }
        })
    }
}

/**
 * Essa função cria uma chamada de click no adapter ^^
 */


//    interface OnItemClickListener{
//        fun onItemClicked(position: Int, view : View)
//    }

//        recyclerView.addOnItemClickListener(object : OnItemClickListener{
//            override fun onItemClicked(position: Int, view: View) {
//                //System.out.println("CLICKED")
//            }
//
//        })


//    fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener){
//        this.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener{
//            override fun onChildViewDetachedFromWindow(view: View) {
//                view?.setOnClickListener(null)
//            }
//
//            override fun onChildViewAttachedToWindow(view: View) {
//               view?.setOnClickListener({
//                   val holder = getChildViewHolder(view)
//                   onClickListener.onItemClicked(holder.adapterPosition, view)
//               })
//            }
//
//        })
//    }