package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Card
import com.example.myapplication.CardAdapter
import com.example.myapplication.R
import com.example.myapplication.ui.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class CardFragment : Fragment() {

    private var columnCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val cards = mutableListOf<Card>()

        val adapter = CardAdapter(cards)
        //add current ban list
        //spell green #6cdfc5
        //purple #cc92c4
        // orange? #ffcc77
        // link blue #CAE4F1
        // grey #808080
        // since image is also string, store whole thing in json in future
        cards.add(createCard("https://s3.duellinksmeta.com/cards/60c2b3aca0e24f2d54a53151_w420.webp","Pot of Greed","Spell",0,0,0,listOf(),"Draw two cards","#6cdfc5"))
        cards.add(createCard("https://s3.duellinksmeta.com/cards/60c2b3aaa0e24f2d54a519e5_w420.webp","Confiscation","Spell",0,0,0,listOf(),"Pay 1000 Life Points. Look at your opponent's hand, select 1 card in it and discard that card.","#6cdfc5"))
        cards.add(createCard("https://s3.duellinksmeta.com/cards/60c2b3aaa0e24f2d54a51aa1_w420.webp","Crystron Halqifibrax","Link-2",0,0,0,listOf("Machine","Link","Effect"),"If this card is Link Summoned: You can Special Summon 1 Level 3 or lower Tuner from your hand or Deck in Defense Position, but it cannot activate its effects this turn. During your opponent's Main Phase or Battle Phase (Quick Effect): You can banish this card you control; Special Summon 1 Tuner Synchro Monster from your Extra Deck. (This is treated as a Synchro Summon.) You can only use each effect of \"Crystron Halqifibrax\" once per turn.","#CAE4F1"))
        cards.add(createCard("https://s3.duellinksmeta.com/cards/60c2b3aca0e24f2d54a53af3_w420.webp","Toadally Awesome","2 level 2 Aqua monsters",0,0,0,listOf("Aqua","Xyz","Effect"),"Once per turn, during the Standby Phase: You can detach 1 Xyz Material from this card; Special Summon 1 \"Frog\" monster from your Deck. Once per turn, during either player's turn, when your opponent activates a Spell/Trap Card, or monster effect: You can send 1 Aqua-Type monster from your hand or face-up from your field to the Graveyard; negate the activation, and if you do, destroy that card, then you can Set it to your field. If this card is sent to the Graveyard: You can target 1 WATER monster in your Graveyard; add it to your hand.","#808080"))
        cards.add(createCard("https://s3.duellinksmeta.com/cards/60c2b3aba0e24f2d54a526dc_w420.webp","Imperial Order","Continuous Trap",0,0,0,listOf(),"Negate all Spell effects on the field. Once per turn, during the Standby Phase, you must pay 700 LP (this is not optional), or this card is destroyed.","#cc92c4"))

        recyclerView.adapter = adapter
        // Set the adapter
        return view
    }
    private fun createCard(image:String,name:String,attribute:String,level:Int,attack:Int,defense: Int,type: List<String>,effect: String,border: String,) = Card(
        image = image,
        name = name,
        attribute = attribute,
        level = level,
        attack = attack,
        defense = defense,
        type = type,
        effect = effect,
        border = border,
    )
}