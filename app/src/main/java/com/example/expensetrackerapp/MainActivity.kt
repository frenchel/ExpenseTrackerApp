package com.example.expensetrackerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    /*HELLOOOOOO -dyogi*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*BOTTOM NAVIGATION - CHANGING FRAGMENTS*/
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.overview -> {
                    replaceFragment(OverviewFragment())
                    true
                }
                R.id.records -> {
                    replaceFragment(RecordsFragment())
                    true
                }
                R.id.wallets -> {
                    replaceFragment(WalletsFragment())
                    true
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(OverviewFragment())

        /*FLOATING ACTION BUTTON - ADD RECORD*/

    }

    /*FUNCTION FOR REPLACING THE FRAGMENTS*/
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }

    /*FUNCTION FOR DISPLAYING ADD RECORD DIALOG*/

}