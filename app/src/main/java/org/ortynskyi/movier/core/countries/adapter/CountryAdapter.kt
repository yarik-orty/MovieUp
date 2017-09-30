package org.ortynskyi.movier.core.countries.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_country.view.*
import org.ortynskyi.movier.R
import org.ortynskyi.movier.core.countries.viewmodel.model.CountryVm

class CountryAdapter(val countries: ArrayList<CountryVm>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_country, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindCountry(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    fun addCountries(countries: List<CountryVm>) {
        this.countries.addAll(countries)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindCountry(country: CountryVm) {
            itemView.countryName.text = country.name
            itemView.countryPopulation.text = country.population.toString()
        }
    }
}