package com.pickcocast.viewpagerexercise

import androidx.cardview.widget.CardView

interface CardAdapter {
    val MAX_ELEVATION_FACTOR : Int//그림자 설정
    fun getBaseElevation() : Float
    fun getCardViewAt(position : Int) : CardView//해당 포지션의 카드뷰 객체 얻어옴
    fun getCount() : Int
}