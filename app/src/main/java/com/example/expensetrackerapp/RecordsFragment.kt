package com.example.expensetrackerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecordsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>

    private val months = arrayOf(
        "All", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    private val years = arrayOf("All", "2021", "2022", "2023", "2024", "2025", )

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        imageList = arrayOf(
            R.drawable.cute_dog
        )

        titleList = arrayOf(
            "1st Term Tuition Fee"
        )
    }

    private fun getData() {
        for(i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // RECYCLER
        val view = inflater.inflate(R.layout.fragment_records, container, false)
        recyclerView = view.findViewById(R.id.recyclerRecords)
        recyclerView.layoutManager = LinearLayoutManager(requireContext()) // Use requireContext() to get the Context.
        recyclerView.setHasFixedSize(true)
        dataList = ArrayList()
        getData()

        // SPINNER
        val monthSpinner = view.findViewById<Spinner>(R.id.dropdownMonth)
        val yearSpinner = view.findViewById<Spinner>(R.id.dropdownYear)

        val monthAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, months)
        val yearAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, years)

        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        monthSpinner.adapter = monthAdapter
        yearSpinner.adapter = yearAdapter

        return view
    }

}