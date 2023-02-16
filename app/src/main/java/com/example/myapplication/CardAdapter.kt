package com.example.myapplication


import android.annotation.SuppressLint
import android.graphics.Color
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.ui.DetailFragment

class CardAdapter(private val cards:List<Card>): RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View,
    private val onItemClick: (adapterPosition: Int)-> Unit
    ):RecyclerView.ViewHolder(itemView){

        val cardName: TextView = itemView.findViewById(R.id.card_name)
        val attribute : TextView = itemView.findViewById(R.id.card_attribute)
        val cardImage  : ImageView = itemView.findViewById(R.id.card_image)
       // val attack: Int,
       // val defense: Int,
        val type : TextView = itemView.findViewById(R.id.card_type)
        val cardEffect: TextView = itemView.findViewById(R.id.card_effect)
       // val border: String,
        init{
            itemView.setOnClickListener{
                onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_card_view, parent, false)
        return CardViewHolder(view){
            val card = cards[it]
            val bundle = bundleOf(
                "name" to card.name,
                "effect" to card.effect,
                "attribute" to card.attribute,
                //"level" to card.level,
                //"attack" to card.attack,
                //"defence" to card.defense,
                "border" to card.border,
            )
            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            val activity = view.context as AppCompatActivity
            activity.supportFragmentManager.commit{
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view,detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        Glide.with(holder.cardImage)
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