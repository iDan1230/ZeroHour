package com.yzd.own.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yzd.own.R
import org.jetbrains.anko.onClick

/**
 * Created by yangzhidan on 2018/10/19.
 */
class AdapterNBA(var mContext: Context, var datas: ArrayList<String>) : RecyclerView.Adapter<AdapterNBA.ViewHolder>() {


    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNBA.ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_events_nba, parent, false))
    }

    override fun onBindViewHolder(holder: AdapterNBA.ViewHolder, position: Int) {
        holder.itemView.onClick {
            Log.e("tag", "aaaaaaaaaaaaaaaa")
        }
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {}
}