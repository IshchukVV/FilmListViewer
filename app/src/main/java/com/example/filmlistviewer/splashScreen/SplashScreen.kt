package com.example.filmlistviewer.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.filmlistviewer.movieList.MovieListActivity
import com.example.filmlistviewer.R
import kotlinx.android.synthetic.main.activity_main.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_act)
        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {
        Handler().postDelayed(
            {
                val intent = Intent(this@SplashScreen, MovieListActivity::class.java)
                startActivity(intent)
                finish()
            },
            1000L
        )
    }
}