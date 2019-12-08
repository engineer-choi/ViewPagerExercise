package com.pickcocast.viewpagerexercise

import androidx.cardview.widget.CardView

interface CardAdapter {
    val MAX_ELEVATION_FACTOR : Int
    fun getBaseElevation() : Float
    fun getCardViewAt(position : Int) : CardView
    fun getCount() : Int
}