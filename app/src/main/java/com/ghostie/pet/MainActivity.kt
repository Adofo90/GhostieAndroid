package com.ghostie.pet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menuItem: android.view.MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.nav_home -> {
                // Handle home navigation
                true
            }
            R.id.nav_settings -> {
                // Handle settings navigation
                true
            }
            else -> false
        }
    }
}
