package com.example.bethehero.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bethehero.IncidentDetails
import com.example.bethehero.Model.Incident
import com.example.bethehero.R
import kotlinx.android.synthetic.main.incidens_item.view.*

class IncidentsAdapter(val context: Context) : RecyclerView.Adapter<IncidentsAdapter.IncidentsViewHolder>(){

    var incidents : List<Incident> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= IncidentsViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.incidens_item, parent, false)
    )

    override fun getItemCount() = incidents.size

    override fun onBindViewHolder(holder: IncidentsViewHolder, position: Int) {
        holder.bind(incidents[position])
    }

    inner class IncidentsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val intent: Intent? = null
        private val textTitle = view.txt_case_title
        private val textValue = view.txt_value
        private val textOngName = view.txt_ong_name
        private val btnDetails = view.btn_details

        fun bind(_data:Incident){
            //TODO FORMATAR TEXTO DO VALOR PARA DECIMAL TYPE
            textTitle.text = _data.title
            textValue.text = _data.value.toString()
            textOngName.text = _data.ongName

            btnDetails.setOnClickListener{
                context.startActivity(Intent(context,IncidentDetails::class.java))
            }

        }
    }



    /**SetIncidentsList
     * Essa função é formatada dessa forma porque o json já vem formatado do backend, não precisa fazer o tratamento de um array
     */
    fun setIncidentsList(incidents: List<Incident>){
        this.incidents = incidents
        notifyDataSetChanged()
    }
}