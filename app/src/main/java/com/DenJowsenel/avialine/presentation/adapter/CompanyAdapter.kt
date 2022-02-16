package com.DenJowsenel.avialine.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.domain.model.Company
import com.bumptech.glide.Glide

typealias OnCompanyClickListener = (Company) -> Unit

class CompanyAdapter (
    private val companies : List<Company>,
    private val listener : OnCompanyClickListener,
) : RecyclerView.Adapter<CompanyAdapter.CompanyVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CompanyVH(
            layoutInflater.inflate(R.layout.item_company, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: CompanyVH, position: Int) =
        holder.bind(companies[position])

    override fun getItemCount(): Int = companies.size


    class CompanyVH(
        view: View,
        listener: OnCompanyClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val company_IMG = view.findViewById<ImageView>(R.id.imageCompany)
        private val company_NAME = view.findViewById<TextView>(R.id.nameCompany)
        private val company_DESC = view.findViewById<TextView>(R.id.descCompany)
        private lateinit var company: Company

        init {
            view.setOnClickListener { listener(company) }
        }

        fun bind(company: Company) {
            this.company = company
            company_NAME.text = company.company_name
            company_DESC.text = company.company_desc
            Glide
                .with(itemView)
                .load(company.imageCompanyURL)
                .centerCrop()
                .placeholder(R.drawable.ic_search)
                .into(company_IMG)
        }
    }
}