package com.lizwe.instalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //-------------------ADS START------------------------------
        MobileAds.initialize(this) {}

        mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                Log.d("Ad Loaded", "Ad has been loaded")
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.d("Ad Error", adError.toString())
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Toast.makeText(this@MainActivity, "Thank you for clicking on this ad!", Toast.LENGTH_LONG)
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.d("Ad Closed", "Ad has been closed")
            }
        }
        //---------------------ADS END-------------------------

        val crimeCard = findViewById<CardView>(R.id.card_crime)
        val serviceCard = findViewById<CardView>(R.id.card_service)
        val accidentCard = findViewById<CardView>(R.id.card_accident)

        crimeCard.setOnClickListener{
            val intent = Intent(this, CrimeActivity::class.java)
            startActivity(intent)
    }
        serviceCard.setOnClickListener{
            val intent = Intent(this,ServiceActivity::class.java)
            startActivity(intent)
        }
        accidentCard.setOnClickListener{
            val intent = Intent(this,AccidentActivity::class.java)
            startActivity(intent)
        }
    }
}