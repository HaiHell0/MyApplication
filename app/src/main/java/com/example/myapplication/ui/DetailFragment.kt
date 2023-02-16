package com.example.myapplication.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R

class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.fragment_detail, container, false)
        if(arguments != null){
            val name = requireArguments().getString("name")
            val card_image = requireArguments().getString("image")
            val card_effect = requireArguments().getString("effect")
            val card_attribute = requireArguments().getString("attribute")
            val card_border = requireArguments().getString("border")
            Glide.with(view).load(card_image).into(view.findViewById<ImageView>(R.id.card_image))
            view.findViewById<TextView>(R.id.card_name).text = name
            view.findViewById<TextView>(R.id.card_attribute).text = card_attribute
            view.findViewById<TextView>(R.id.card_effect).text = card_effect
            view.setBackgroundColor(Color.parseColor(card_border))


        }
        return view
    }


}