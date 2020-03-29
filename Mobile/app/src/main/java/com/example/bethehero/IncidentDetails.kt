package com.example.bethehero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_incident_details.*

class IncidentDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incident_details)

        val actionbar = supportActionBar
        actionbar!!.title = "Voltar"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val value = intent.getStringExtra("value")
        val ongName = intent.getStringExtra("ongName")

        mountActivity(title, description, value, ongName)
    }

    private fun mountActivity(title: String?, description: String?, value: String?, ongName: String?) {
        text_caso.text = title
        text_ongname.text = ongName
        text_value.text = value
        text_description.text = description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
