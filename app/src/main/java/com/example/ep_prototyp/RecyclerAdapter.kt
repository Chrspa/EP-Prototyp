package com.example.ep_prototyp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (val list: List<String>, val type: Int) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    private var listener: SeekBarListener? = null //listener-variable
    companion object {
        private const val cardViewRating = 0
        private const val cardViewGoldenBehaviors = 1
    }


    fun setSeekBarListener(listener: SeekBarListener) { // Funktion, die listener setzt
        this.listener = listener
    }

    override fun getItemViewType(position: Int): Int {
        return if (type == 0) {
            cardViewRating
        } else {
            cardViewGoldenBehaviors
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (type) {
            cardViewRating -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_behaviors, parent, false)
                ViewHolderRating(v)
            }
            cardViewGoldenBehaviors -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_golden_behaviors, parent, false)
                ViewHolder(v)
            }
            else -> throw IllegalArgumentException("Das hat nicht geklappt.")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.itemTitle.text = item
    }



    override fun getItemCount(): Int {
        return list.size
    }

    interface SeekBarListener { // Interface, um SeeBar-Progress zum Fragment durchzugeben
        fun onSeekBarChanged(position: Int, progress: Int)
    }

    //für zweiten CardView (einmal mit, einmal ohne SeekBar) mit inheritance gearbeitet
    open class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle = itemView.findViewById<TextView>(R.id.behaviorName)
        var itemImage = itemView.findViewById<ImageView>(R.id.image_behavior)
    }


    inner class ViewHolderRating(itemView: View): ViewHolder(itemView) {
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
