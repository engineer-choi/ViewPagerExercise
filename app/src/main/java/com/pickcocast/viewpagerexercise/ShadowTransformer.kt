package com.pickcocast.viewpagerexercise

import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.viewpager.widget.ViewPager

class ShadowTransformer(val mViewPager:ViewPager,val mAdapter : CardAdapter) : ViewPager.OnPageChangeListener, ViewPager.PageTransformer{

    var mLastOffset : Float = 0f
    init {
        mViewPager.addOnPageChangeListener(this)



    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        var realCurrentPosition : Int = 0
        var nextPosition : Int = 0
        var realOffset : Float = 0f
        var goingLeft : Boolean = mLastOffset > positionOffset
        var baseElevation : Float = mAdapter.getBaseElevation()
        if(goingLeft){
            realCurrentPosition = position+1
            nextPosition = position
            realOffset = 1-positionOffset
        }else{
            nextPosition = position+1
            realCurrentPosition = position
            realOffset = positionOffset
        }
        if(nextPosition > mAdapter.getCount() -1 || realCurrentPosition>mAdapter.getCount()-1){
            return
        }

        val realCurrentCard : CardView = mAdapter.getCardViewAt(realCurrentPosition)


        realCurrentCard.scaleX=(1+0.3*(1-realOffset)).toFloat()
        realCurrentCard.scaleY=(1+0.3*(1-realOffset)).toFloat()

        val elevation : Int = 8
        realCurrentCard.cardElevation = baseElevation + baseElevation*(elevation-1)*(1-realOffset)

        val nextCard : CardView = mAdapter.getCardViewAt(nextPosition)

        nextCard.scaleX = (1+0.3*(realOffset)).toFloat()
        nextCard.scaleY = (1+0.3*(realOffset)).toFloat()
        nextCard.cardElevation = baseElevation + baseElevation*(elevation-1)*(realOffset)
        mLastOffset = positionOffset
    }

    override fun onPageSelected(position: Int) {

    }

    override fun transformPage(page: View, position: Float) {

    }

}