package com.example.forismatic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forismatic.databinding.QouteListItemBinding

class QouteAdapter : RecyclerView.Adapter<QouteAdapter.QouteViewHolder>() {

    class QouteViewHolder(val binding: QouteListItemBinding) : RecyclerView.ViewHolder(binding.root)

    var qouteList = emptyList<Model>()

    set(value) {
        field=value
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QouteViewHolder {
        return QouteViewHolder(QouteListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: QouteViewHolder, position: Int) {
        holder.binding.tvQoute.text = qouteList[position].quoteText
        holder.binding.tvAutor.text = qouteList[position].quoteAuthor
    }

    override fun getItemCount(): Int {
        return qouteList.size
    }
}