package com.DenJowsenel.avialine.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.adapter.CompanyAdapter
import com.DenJowsenel.avialine.data.DataSource

class CompaniesActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companies)
        val rvBrands = findViewById<RecyclerView>(R.id.rvCompany)
        rvBrands.layoutManager = LinearLayoutManager(this)
        rvBrands.adapter = CompanyAdapter(DataSource.Companies) {
            val intent = Intent(this, RoutesActivity::class.java)
            startActivity(intent)
        }
    }
}
