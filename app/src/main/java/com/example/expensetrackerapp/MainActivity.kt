package com.example.expensetrackerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

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
        var addRecordButton = findViewById<FloatingActionButton>(R.id.fab)
        addRecordButton.setOnClickListener {
            showAddRecordFragment()
            bottomNavigationView.selectedItemId = 0
        }
    }

    /*FUNCTION FOR REPLACING THE FRAGMENTS - BOTTOM NAVIGATION*/
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }

    /*FUNCTION FOR ADD RECORD FRAGMENT*/
    private fun showAddRecordFragment() {
        val nextFragment = AddRecordFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, nextFragment).commit()
    }

    private fun FloatingActionButton.setOnClickListener(showAddRecordFragment: Any ) {

    }
}