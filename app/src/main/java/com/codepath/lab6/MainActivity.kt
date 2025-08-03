
package com.codepath.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codepath.lab6.databinding.ActivityMainBinding
import kotlinx.serialization.json.Json

fun createJson() = Json {
    ignoreUnknownKeys = true
    isLenient = true
    coerceInputValues = true
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show Parks by default when opening the app.
        if (savedInstanceState == null) {
            loadFragment(ParksFragment())
        }

        // Switch screens when a bottom navigation tab is tapped.
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_parks -> {
                    loadFragment(ParksFragment())
                    true
                }

                R.id.nav_campgrounds -> {
                    loadFragment(CampgroundFragment())
                    true
                }

                else -> false
            }
        }

        // Keep the selected tab synchronized with the displayed screen.
        binding.bottomNavigation.selectedItemId =
            if (savedInstanceState == null) {
                R.id.nav_parks
            } else {
                binding.bottomNavigation.selectedItemId
            }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
