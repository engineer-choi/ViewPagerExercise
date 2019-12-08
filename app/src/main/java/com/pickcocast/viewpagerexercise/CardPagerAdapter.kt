package com.pickcocast.viewpagerexercise


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter

class CardPagerAdapter(override val MAX_ELEVATION_FACTOR: Int) : CardAdapter, PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    var mViews = mutableListOf<CardView?>()
    var mData = mutableListOf<CardItem>()
    var mBaseElevation: Float = 0.0f

    fun addCardItem(item : CardItem) {
        mViews.add(null)
        mData.add(item)
    }

    override fun getBaseElevation() : Float {
        return mBaseElevation
    }

    override fun getCardViewAt(position: Int): CardView {
        return mViews.get(position)!!
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view : View = LayoutInflater.from(container.context)
            .inflate(R.layout.item,container,false)
        container.addView(view)
        bind(mData.get(position),view)
        val cardView : CardView = view.findViewById(R.id.cardView)

        if(mBaseElevation == 0f){
            mBaseElevation = cardView.cardElevation
        }
        cardView.maxCardElevation=mBaseElevation*MAX_ELEVATION_FACTOR
        mViews.set(position,cardView)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
        mViews.set(position,null)
    }

    private fun bind(item:CardItem , view : View){
        val titleTextView : TextView= view.findViewById(R.id.titleTextView)
        val contentTextView  : TextView= view.findViewById(R.id.contentTextView)
        titleTextView.text=item.title_resource.toString()
        contentTextView.text = item.text_resource.toString()
    }
}