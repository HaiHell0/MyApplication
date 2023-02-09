package com.example.myapplication

data class Card (
    val image: Int,
    val name: String,
    val attribute: String,
    val level: Int,
    val attack: Int,
    val defense: Int,
    val type: List<String>,
    val effect: String,
    val border: String,
)