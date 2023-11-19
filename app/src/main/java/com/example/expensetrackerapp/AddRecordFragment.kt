package com.example.expensetrackerapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddRecordFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: AdapterClass
    private val userList: ArrayList<DataClass> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userAdapter = AdapterClass(requireContext(), userList)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add_record, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = userAdapter

        /*DROPDOWN - TRANSACTION AND CATEGORIES*/
        val dropdownTransactions = resources.getStringArray(R.array.transactions)
        val dropdownCategories = resources.getStringArray(R.array.categories)

        val transactionTypeAdapter =
            ArrayAdapter(requireContext(), R.layout.dropdown_item, dropdownTransactions)
        val categoryAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, dropdownCategories)

        val etTransactionType = view.findViewById<AutoCompleteTextView>(R.id.et_transactionType)
        val etCategory = view.findViewById<AutoCompleteTextView>(R.id.et_category)

        etTransactionType.setAdapter(transactionTypeAdapter)
        etCategory.setAdapter(categoryAdapter)

        /*DROPDOWN - DATE*/
        val etDateView = view.findViewById<TextInputLayout>(R.id.et_date_view)
        val etDate = view.findViewById<TextInputEditText>(R.id.et_date)

        etDateView.setEndIconOnClickListener {
            showDatePicker(etDate)
        }

        /*BUTTON - SAVE RECORD*/
        val saveAddRecordButton = view.findViewById<Button>(R.id.saveAddRecord)
        saveAddRecordButton.setOnClickListener {

            // kinukuha mga input sa textfield
            val title = view.findViewById<TextInputEditText>(R.id.et_title).text.toString()
            val amount = view.findViewById<TextInputEditText>(R.id.et_amount).text.toString()
            val transactionType = etTransactionType.text.toString()
            val category = etCategory.text.toString()
            val date = etDate.text.toString()
            val note = view.findViewById<TextInputEditText>(R.id.et_note).text.toString()

            // new data class instance gaya sa vid
            val newData = DataClass(title, amount, transactionType, category, date, note)
            //nilalagay new data
            userList.add(newData)

            userAdapter.notifyDataSetChanged()

            /*view.findViewById<TextInputEditText>(R.id.et_title).setText("")
            view.findViewById<TextInputEditText>(R.id.et_amount).setText("")
            etTransactionType.setText("")
            etCategory.setText("")
            etDate.setText("")
            view.findViewById<TextInputEditText>(R.id.et_note).setText("")*/

            // punta overview fragment pagkasave
            val newFragment = OverviewFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        /*val saveAddRecordButton = view.findViewById<Button>(R.id.saveAddRecord)
        saveAddRecordButton.setOnClickListener {

            try {
                // Extract data from input fields
                val title = view.findViewById<TextInputEditText>(R.id.et_title).text.toString()
                val amount = view.findViewById<TextInputEditText>(R.id.et_amount).text.toString()
                val transactionType = etTransactionType.text.toString()
                val category = etCategory.text.toString()
                val date = etDate.text.toString()
                val note = view.findViewById<TextInputEditText>(R.id.et_note).text.toString()

                // Check if any of the required fields are empty
                if (title.isEmpty() || amount.isEmpty() || transactionType.isEmpty() || category.isEmpty() || date.isEmpty()) {
                    // Show a Toast or handle the error appropriately
                    // For example, Toast.makeText(requireContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Create a new DataClass instance
                val newData = DataClass(title, amount, transactionType, category, date, note)

                // Add the new data to the user list
                userList.add(newData)

                // Notify the adapter that data has changed
                userAdapter.notifyDataSetChanged()

                // Clear input fields
                view.findViewById<TextInputEditText>(R.id.et_title).setText("")
                view.findViewById<TextInputEditText>(R.id.et_amount).setText("")
                etTransactionType.setText("")
                etCategory.setText("")
                etDate.setText("")
                view.findViewById<TextInputEditText>(R.id.et_note).setText("")

                // Navigate to the OverviewFragment or perform any other desired action
                val newFragment = OverviewFragment()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_layout, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            } catch (e: Exception) {
                // Handle any exceptions that might occur during data extraction or processing
                e.printStackTrace()
                // Show a Toast or log the error
                // For example, Toast.makeText(requireContext(), "An error occurred", Toast.LENGTH_SHORT).show()
            }
        }*/

        return view
    }

    /*FUNCTION FOR DATE PICKER*/
    fun showDatePicker(editText: TextInputEditText) {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            R.style.datePicker,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                editText.setText(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            null
        )

        datePickerDialog.show()
    }
}
