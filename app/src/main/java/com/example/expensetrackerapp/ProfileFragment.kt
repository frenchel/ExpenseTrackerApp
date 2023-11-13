package com.example.expensetrackerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class ProfileFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        //User Account Fragment
        val toAccountFragment = view.findViewById<ConstraintLayout>(R.id.constraintAccount)
        toAccountFragment.setOnClickListener {
            val newFragment = UserAccountFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        //Categories Fragment
        val toCategoriesFragment = view.findViewById<ConstraintLayout>(R.id.constraintCategories)
        toCategoriesFragment.setOnClickListener {
            val newFragment = CategoriesFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        //Notifications Fragment
        val toNotificationsFragment = view.findViewById<ConstraintLayout>(R.id.constraintNotifications)
        toNotificationsFragment.setOnClickListener {
            val newFragment = NotificationsFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        //Logout

        return view
    }
}