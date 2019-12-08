package com.pickcocast.viewpagerexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mCardAdapter : CardPagerAdapter
    lateinit var mViewPager : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        mViewPager = findViewById(R.id.viewPager)
        mCardAdapter = CardPagerAdapter(8)
        mCardAdapter.addCardItem(CardItem(title_resource = R.string.title_1,text_resource = R.string.text_1))
        mCardAdapter.addCardItem(CardItem(title_resource = R.string.title_2,text_resource = R.string.text_1))
        mCardAdapter.addCardItem(CardItem(title_resource = R.string.title_3,text_resource = R.string.text_1))
        mCardAdapter.addCardItem(CardItem(title_resource = R.string.title_4,text_resource = R.string.text_1))

        val mCardShadowTransformer = ShadowTransformer(mViewPager,mCardAdapter)

        mViewPager.adapter = mCardAdapter
        mViewPager.setPageTransformer(false,mCardShadowTransformer)
        mViewPager.offscreenPageLimit=3
    }
}
