package com.example.lesson43

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VerticalPostAdapter: RecyclerView.Adapter<VerticalPostViewHolder>() {

    var models: List<Post> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalPostViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return VerticalPostViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerticalPostViewHolder, position: Int) {
        holder.pupulateModel(models[position])
    }

    override fun getItemCount(): Int = models.size
}