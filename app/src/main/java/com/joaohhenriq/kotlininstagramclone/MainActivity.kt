package com.joaohhenriq.kotlininstagramclone

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.joaohhenriq.kotlininstagramclone.fragments.HomeFragment
import com.joaohhenriq.kotlininstagramclone.fragments.NotificationsFragment
import com.joaohhenriq.kotlininstagramclone.fragments.ProfileFragment
import com.joaohhenriq.kotlininstagramclone.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private var selectedFragment: Fragment? = null

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    selectedFragment = HomeFragment()
                }
                R.id.nav_search -> {
                    selectedFragment = SearchFragment()
                }
                R.id.nav_add_post -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_notifications -> {
                    selectedFragment = NotificationsFragment()
                }
                R.id.nav_profile -> {
                    selectedFragment = ProfileFragment()
                }
            }

            if(selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    selectedFragment!!
                ).commit()
            }

            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        //sets the first fragment to be shown in the app
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            HomeFragment()
        ).commit()
    }
}