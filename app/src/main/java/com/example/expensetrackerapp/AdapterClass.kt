package com.example.expensetrackerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class AdapterClass(val context: Context, val userList: ArrayList<DataClass>) :
    RecyclerView.Adapter<AdapterClass.UserViewHolder>() {

    inner class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextInputEditText>(R.id.et_title)
        val amount = view.findViewById<TextInputEditText>(R.id.et_amount)
        val transactionType = view.findViewById<TextInputEditText>(R.id.et_transactionType)
        val category = view.findViewById<TextInputEditText>(R.id.et_category)
        val date = view.findViewById<TextInputEditText>(R.id.et_date)
        val note = view.findViewById<TextInputEditText>(R.id.et_note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newData = userList[position]
        holder.title.setText(newData.title)
        holder.amount.setText(newData.amount)
        holder.transactionType.setText(newData.transactionType)
        holder.category.setText(newData.category)
        holder.date.setText(newData.date)
        holder.note.setText(newData.note)
    }
}


/* ITO YUNG LUMA
class AdapterClass(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position:Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.rvIcon)
        val rvTitle: TextView = itemView.findViewById(R.id.rvTitle)
    }
}*/
