package com.example.bethehero.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bethehero.IncidentsActivity
import com.example.bethehero.Model.Ong
import com.example.bethehero.R
import kotlinx.android.synthetic.main.ongs_item.view.*

class OngsAdapter (val context: Context) : RecyclerView.Adapter<OngsAdapter.OngsViewHolder>(){

    var ongs : List<Ong> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OngsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.ongs_item, parent, false)
    )

    override fun getItemCount() = ongs.size

    override fun onBindViewHolder(holder: OngsViewHolder, position: Int) {
        holder.bind(ongs[position])
    }


    inner class OngsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var intent = Intent(context, IncidentsActivity::class.java)

        private var ong_id : String = ""
        private var ongName = view.txt_ong_name
        private var cidade = view.txt_city
        private var uf = view.txt_uf
        private var email = view.txt_mail
        private var btnDetails = view.btn_details

        fun bind(_data:Ong){
            ong_id = _data.id

            ongName.text = _data.name
            cidade.text = _data.city
            uf.text = _data.uf
            email.text = _data.email

            btnDetails.setOnClickListener{
                intent.putExtra("ong_id", ong_id)
                context.startActivity(intent)
            }
        }
    }


    fun setOng(ongs: List<Ong>){
        this.ongs = ongs
        notifyDataSetChanged()
    }
}