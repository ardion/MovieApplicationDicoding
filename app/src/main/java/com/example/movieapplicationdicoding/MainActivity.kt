package com.example.movieapplicationdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.core.ui.showSnackbar
import com.example.movieapplicationdicoding.databinding.ActivityMainBinding
import com.example.movieapplicationdicoding.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.favorite -> {
                    try {
                        moveToFavoriteActivity()
                    } catch (e: Exception) {
                        showSnackbar(view, this)
                    }
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun moveToFavoriteActivity() {
        startActivity(Intent(this, Class.forName("com.example.favorite.FavoriteActivity")))
    }
}