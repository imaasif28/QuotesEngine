package com.aasif.quotesengine

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aasif.quotesengine.databinding.ListItemQuoteBinding

class QuotesAdapter(private var quotes: List<String>) :
    RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemQuoteBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = quotes.size

    inner class ViewHolder(private var binding: ListItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            position: Int,
        ) {
            val quote = quotes[position]
            val colors = arrayOf("#448AFF", "#FFC107", "#009688", "#E91E63", "#FF5722")
            val color = position % colors.size
            val intColor = Color.parseColor(colors[color])
            binding.txtQuote.text = quote
            binding.imgQuote.setBackgroundColor(intColor)
        }
    }
}