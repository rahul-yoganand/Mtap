package com.example.mtap.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mtap.R

class MainFrag : AppCompatActivity(),HeadLines.OnHeadLineClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frag)
    }

    override fun onHeadClick(headline: String) {
        var newsDetails: NewsDetails =
            supportFragmentManager.findFragmentById(R.id.newsDetailsContainer) as NewsDetails
        newsDetails.tvNews.text=headline
    }
}