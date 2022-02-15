package com.DenJowsenel.avialine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.model.Route

typealias OnRouteClickListener = (Route) -> Unit

class RouteAdapter (
    private val routes : List<Route>,
    private val listener : OnRouteClickListener,
) : RecyclerView.Adapter<RouteAdapter.RouteVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RouteVH(
            layoutInflater.inflate(R.layout.item_flight_route, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: RouteVH, position: Int) =
        holder.bind(routes[position])

    override fun getItemCount(): Int = routes.size

    class RouteVH(
        view: View,
        listener: OnRouteClickListener
    ) : RecyclerView.ViewHolder(view) {
        private val road = view.findViewById<TextView>(R.id.Road)
        private val price = view.findViewById<TextView>(R.id.PriceCount)
        private val place = view.findViewById<TextView>(R.id.placeCount)
        private val priceVip = view.findViewById<TextView>(R.id.PriceCountVIP)
        private val placeVip = view.findViewById<TextView>(R.id.placeCountVIP)
        private lateinit var route: Route

        init {
            view.setOnClickListener { listener(route) }
        }

        fun bind(route: Route) {
            this.route = route
            road.text = route.route
            price.text = route.price
            place.text = route.place
            priceVip.text = route.priceVip
            placeVip.text = route.placeVip
        }
    }
}