package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.card_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cards = mutableListOf<Card>()

        val adapter = CardAdapter(cards)
        //add current ban list
        //spell green #6cdfc5
        //purple #cc92c4
        // orange? #ffcc77
        // link blue #CAE4F1
        // grey #808080

        cards.add(createCard(R.drawable.potofgreed,"Pot of Greed","Spell",0,0,0,listOf(),"Draw two cards","#6cdfc5"))
        cards.add(createCard(R.drawable.confiscation,"Confiscation","Spell",0,0,0,listOf(),"Pay 1000 Life Points. Look at your opponent's hand, select 1 card in it and discard that card.","#6cdfc5"))
        cards.add(createCard(R.drawable.crystronhalq,"Crystron Halqifibrax","Link-2",0,0,0,listOf("Machine","Link","Effect"),"If this card is Link Summoned: You can Special Summon 1 Level 3 or lower Tuner from your hand or Deck in Defense Position, but it cannot activate its effects this turn. During your opponent's Main Phase or Battle Phase (Quick Effect): You can banish this card you control; Special Summon 1 Tuner Synchro Monster from your Extra Deck. (This is treated as a Synchro Summon.) You can only use each effect of \"Crystron Halqifibrax\" once per turn.","#CAE4F1"))
        cards.add(createCard(R.drawable.toadally,"Toadally Awesome","2 level 2 Aqua monsters",0,0,0,listOf("Aqua","Xyz","Effect"),"Once per turn, during the Standby Phase: You can detach 1 Xyz Material from this card; Special Summon 1 \"Frog\" monster from your Deck. Once per turn, during either player's turn, when your opponent activates a Spell/Trap Card, or monster effect: You can send 1 Aqua-Type monster from your hand or face-up from your field to the Graveyard; negate the activation, and if you do, destroy that card, then you can Set it to your field. If this card is sent to the Graveyard: You can target 1 WATER monster in your Graveyard; add it to your hand.","#808080"))
        cards.add(createCard(R.drawable.imperialorder,"Imperial Order","Continuous Trap",0,0,0,listOf(),"Negate all Spell effects on the field. Once per turn, during the Standby Phase, you must pay 700 LP (this is not optional), or this card is destroyed.","#cc92c4"))

        recyclerView.adapter = adapter

    }
    private fun createCard(image:Int,name:String,attribute:String,level:Int,attack:Int,defense: Int,type: List<String>,effect: String,border: String,) = Card(
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