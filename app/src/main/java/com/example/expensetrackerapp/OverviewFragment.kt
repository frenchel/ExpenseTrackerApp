package com.example.expensetrackerapp

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class OverviewFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview, container, false)


        //TOP EXPENSE 1 - YUNG PINAKAMATAAS NA TOTAL EXPENSE FOR THE LAST 30 DAYS
        val progressbar1 = view.findViewById<ProgressBar>(R.id.topExpense1)
        progressbar1.max = 40000 //kung pwede sana dapat ang max value nito ay yung highest total expense for that month/last 30 days
        val currentProgress = 40000

        ObjectAnimator.ofInt(progressbar1, "progress", currentProgress)
            .setDuration(2000)
            .start()

        //TOP EXPENSE 2
        val progressBar2 = view.findViewById<ProgressBar>(R.id.topExpense2)
        progressBar2.max = 40000
        val currentProgress2 = 15000

        ObjectAnimator.ofInt(progressBar2, "progress", currentProgress2)
            .setDuration(2000)
            .start()

        //TOP EXPENSE 3
        val progressBar3 = view.findViewById<ProgressBar>(R.id.topExpense3)
        progressBar3.max = 40000
        val currentProgress3 = 10000

        ObjectAnimator.ofInt(progressBar3, "progress", currentProgress3)
            .setDuration(2000)
            .start()

        //TOP INCOME 1 - YUNG PINAKAMATAAS NA TOTAL INCOME FOR THE LAST 30 DAYS
        val progressBar4 = view.findViewById<ProgressBar>(R.id.topIncome1)
        progressBar4.max = 50000
        val currentProgress4 = 50000

        ObjectAnimator.ofInt(progressBar4, "progress", currentProgress4)
            .setDuration(2000)
            .start()

        //TOP INCOME 2
        val progressBar5 = view.findViewById<ProgressBar>(R.id.topIncome2)
        progressBar5.max = 50000
        val currentProgress5 = 10000

        ObjectAnimator.ofInt(progressBar5, "progress", currentProgress5)
            .setDuration(2000)
            .start()

        //TOP INCOME 3
        val progressBar6 = view.findViewById<ProgressBar>(R.id.topIncome3)
        progressBar6.max = 50000
        val currentProgress6 = 5000

        ObjectAnimator.ofInt(progressBar6, "progress", currentProgress6)
            .setDuration(2000)
            .start()


        //SEE ALL BUTTON
        val replaceFragmentExpense = view.findViewById<TextView>(R.id.replaceFragmentExpense)
        replaceFragmentExpense.setOnClickListener {
            val newFragment = ExpenseFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val replaceFragmentIncome = view.findViewById<TextView>(R.id.replaceFragmentIncome)
        replaceFragmentIncome.setOnClickListener {
            val newFragment = IncomeFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

}