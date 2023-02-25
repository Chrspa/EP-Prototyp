package com.example.ep_prototyp

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (val list: List<String>, val type: Int) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    private var seekBarListener: SeekBarListener? = null //listener-variable
    private var cardListener : OnClickListener?=  null

    companion object {
        private const val cardViewRating = 0
        private const val cardViewGoldenBehaviors = 1
    }

    fun setSeekBarListener(listener: SeekBarListener) { // Funktion, die listener setzt
        this.seekBarListener = listener
    }

    fun setCardClickListener(listener: OnCardClickListener) {
        this.cardListener = listener
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
                ViewHolderGoldenBehaviors(v)
            }
            else -> throw IllegalArgumentException("Das hat nicht geklappt.")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.itemTitle.text = item
        if (type == 1) {
            holder.itemView.setOnClickListener {
                // Handle click event here
                Toast.makeText(
                    holder.itemView.context,
                    "Card clicked at position $position",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    interface SeekBarListener { // Interface, um SeeBar-Progress zum Fragment durchzugeben
        fun onSeekBarChanged(position: Int, progress: Int)
    }
    interface OnCardClickListener : OnClickListener {
        fun onCardClick(position: Int)
        override fun onClick(p0: View?) {

        }
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
                    seekBarListener?.onSeekBarChanged(adapterPosition, progress) // Pass the SeekBar progress data back to your Fragment via the interface
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}

                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })
        }
    }

    inner class ViewHolderGoldenBehaviors(itemView: View): ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                var clickPosition = absoluteAdapterPosition
                Toast.makeText(itemView.context, "Golden Behavior ausgewählt", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
