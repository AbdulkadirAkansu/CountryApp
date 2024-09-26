package com.akansu.countryapp.adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.akansu.countryapp.R
import com.akansu.countryapp.databinding.ItemCountryBinding
import com.akansu.countryapp.model.Country
import com.akansu.countryapp.view.FeedFragmentDirections


class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener {

    class CountryViewHolder(var binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country,parent,false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.country = countryList[position]
        holder.binding.listener = this
        holder.binding.root.tag = holder.binding
        holder.binding.root.setOnClickListener {
            onCountryClicked(it)
        }
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val binding = v.tag as? ItemCountryBinding ?: return
        val uuid = binding.country?.uuid ?: return
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}