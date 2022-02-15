package com.DenJowsenel.avialine.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.adapter.RoutesAdapter
import com.DenJowsenel.avialine.data.DataSource

class RoutesActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_routes)
        val rvReview = findViewById<RecyclerView>(R.id.rvRoute)
        rvReview.layoutManager = LinearLayoutManager(this)
        rvReview.adapter = RoutesAdapter(DataSource.Routes) {}
    }
}