package com.joaohhenriq.kotlininstagramclone

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    textView.text = "Home"
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_search -> {
                    textView.text = "Search"
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_add_post -> {
                    textView.text = "Add Post"
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_notifications -> {
                    textView.text = "Notifications"
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    textView.text = "Profile"
                    return@OnNavigationItemSelectedListener true
                }
            }

            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        textView = findViewById(R.id.message)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}