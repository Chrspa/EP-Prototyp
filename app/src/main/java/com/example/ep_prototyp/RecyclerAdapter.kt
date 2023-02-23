package com.example.ep_prototyp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (val list: List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    private var listener: SeekBarListener? = null //listener-variable


    fun setSeekBarListener(listener: SeekBarListener) { // Funktion, die listener setzt
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_behaviors, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface SeekBarListener { // Interface, um SeeBar-Progress Define the interface to pass the SeekBar progress data back to your Fragment
        fun onSeekBarChanged(position: Int, progress: Int)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage = itemView.findViewById<ImageView>(R.id.image_behavior)
        var itemTitle = itemView.findViewById<TextView>(R.id.behaviorName)
        var seekBar = itemView.findViewById<SeekBar>(R.id.seekBarBehavior)

        init {
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    listener?.onSeekBarChanged(adapterPosition, progress) // Pass the SeekBar progress data back to your Fragment via the interface
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}

                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })
        }
    }
}
