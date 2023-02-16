package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.*
import com.example.myapplication.ui.CardFragment
import com.example.myapplication.ui.DetailFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit { setReorderingAllowed(true)
        add(R.id.fragment_container_view, CardFragment())
        addToBackStack(null)
        }



    }

}