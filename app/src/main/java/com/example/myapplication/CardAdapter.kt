package com.example.myapplication


import android.annotation.SuppressLint
import android.graphics.Color
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val cards:List<Card>): RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    class CardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val cardName: TextView = itemView.findViewById(R.id.card_name)
        val attribute : TextView = itemView.findViewById(R.id.card_attribute)
        val cardImage  : ImageView = itemView.findViewById(R.id.card_image)
       // val attack: Int,
       // val defense: Int,
        val type : TextView = itemView.findViewById(R.id.card_type)
        val cardEffect: TextView = itemView.findViewById(R.id.card_effect)
       // val border: String,
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CardViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_card_view,parent,false)

    )

    override fun getItemCount(): Int {
        return cards.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.cardName.text = card.name
        holder.cardImage.setImageResource(card.image)
        //holder.cardEffect.text = getString(R.string.effect, card.effect) R.string.effect.. is type Int?
        holder.attribute.text = card.attribute
        holder.type.text = card.type.joinToString("/")
        holder.cardEffect.text = card.effect
        holder.itemView.setBackgroundColor(Color.parseColor(card.border))



    }
}