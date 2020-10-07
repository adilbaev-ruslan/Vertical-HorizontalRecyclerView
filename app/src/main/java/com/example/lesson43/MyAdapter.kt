package com.example.lesson43

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_horizantal.view.*

class MyAdapter(val activity: MainActivity): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var verticalPostAdapter: VerticalPostAdapter = VerticalPostAdapter()

    var models: List<ListItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return models[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        return if (viewType == ListItem.ADS_TYPE) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false)
            AdsViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_horizantal, parent, false)
            PostViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ListItem.ADS_TYPE) {
            (holder as AdsViewHolder).pupulateModel(models[position] as Ads)
        } else {
            (holder as PostViewHolder).pupulateModel(models[position] as VerticalPost)
            setDataVerticalPost(models[position] as VerticalPost)
            holder.itemView.horizontalRecyclerView.setHasFixedSize(true)
            holder.itemView.horizontalRecyclerView.adapter = verticalPostAdapter
            holder.itemView.horizontalRecyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL))
        }
    }

    fun setDataVerticalPost(model: VerticalPost) {
        verticalPostAdapter.models = model.list
    }

    override fun getItemCount(): Int = models.size
}