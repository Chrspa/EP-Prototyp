package com.example.ep_prototyp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter2 (val list: List<String>) : RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter2.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_golden_behaviors, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView1.text = list[position]
    }


    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage = itemView.findViewById<ImageView>(R.id.image_behavior)
        var textView1 = itemView.findViewById<TextView>(R.id.behaviorName)

    }
}