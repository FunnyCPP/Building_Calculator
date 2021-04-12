package com.codart.building_calculator.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import com.codart.building_calculator.R
import com.codart.building_calculator.billing.BillingViewModel
import com.codart.building_calculator.billing.localdb.SubState
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.CategoriesGeneration
import com.codart.building_calculator.models.Space
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class CalculationsActivity : AppCompatActivity() {

    private var toogle: ActionBarDrawerToggle? = null
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    private var mInterstitialAd: InterstitialAd? = null
    private var TAG = "AD MOB"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculations)
        MobileAds.initialize(this) {}
       var adRequest = AdRequest.Builder().build()
        //ca-app-pub-7677251733560484/7261211991
        Log.d("---sub---",SubState.isSubActive().toString())
        if(!SubState.isSubActive()) {
            Log.d("--AD--",SubState.isSubActive().toString())
           // Toast.makeText(this,"AD Will show", Toast.LENGTH_LONG).show()
            val mAdView: AdView = findViewById(R.id.adView)
            val adRequestBanner = AdRequest.Builder().build()
            mAdView.loadAd(adRequestBanner)
            //ca-app-pub-4258310895444755/4464270640
            com.google.android.gms.ads.interstitial.InterstitialAd.load(this, "ca-app-pub-4258310895444755/4464270640", adRequest, object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError?.message)
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: com.google.android.gms.ads.interstitial.InterstitialAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this@CalculationsActivity)
                    } else {
                        Log.d(TAG, "The interstitial ad wasn't ready yet.")
                    }
                    mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                        override fun onAdDismissedFullScreenContent() {
                            Log.d(TAG, "Ad was dismissed.")
                        }

                        override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                            Log.d(TAG, "Ad failed to show.")
                        }

                        override fun onAdShowedFullScreenContent() {
                            Log.d(TAG, "Ad showed fullscreen content.")
                            mInterstitialAd = null;
                        }
                    }
                }
            })
        }
       val navController = Navigation.findNavController(this, R.id.fragment_calculations)
        toolbar = findViewById(R.id.toolbar_calculations)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(resources.getDrawable(R.drawable.ic_arrow_back))
        var id=intent.getIntExtra("id", 1)
        Log.d("id Calculation", id.toString())
        toolbar.title=CategoriesGeneration.calculations[id]
        id++
        toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if(navController.currentDestination!!.label.toString() == "fragment_space")
                {
                    navController.navigate(R.id.action_spaceFragment_to_emptyFragment)
                    Log.d("CHECK", "TRUE")
                }
                else
                    onBackPressed()
            }
        })


    }
    companion object{
        //-------------------------------------
        //functions for work with adding spaces
        //-------------------------------------
        private var spaces: MutableList<Space> = mutableListOf<Space>()
        fun addSpace(space: Space)
        {
            spaces.add(space)
        }
        fun editSpace(space: Space, position: Int): Boolean{
            return if(position < spaces.size) {
                spaces[position]=space
                true
            } else {
                Log.e("space edit ERROR", "position: $position, size: ${spaces.size}")
                false
            }
        }
        fun getSpaces(): MutableList<Space> = spaces
        fun calculateSquare(): Any{
            var s=0.0
            for(space in spaces)
            {
                Log.d("SQUARE", space.square.toString())
                s+=space.square*space.number
            }
            return Round.round(s)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
}