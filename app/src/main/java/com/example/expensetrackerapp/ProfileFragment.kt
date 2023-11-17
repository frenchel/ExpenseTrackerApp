package com.example.expensetrackerapp

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class ProfileFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun showEditProfileDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_editprofile)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val buttonCancel = dialog.findViewById<Button>(R.id.cancelEditProfile)
        buttonCancel.setOnClickListener {
            dialog.dismiss()
        }

        val buttonSave = dialog.findViewById<Button>(R.id.saveEditProfile)
        buttonSave.setOnClickListener {
            dialog.dismiss()
            showSavedDialog()
        }


        dialog.show()
    }

    private fun showSavedDialog() {
        val savedDialog = Dialog(requireContext())
        savedDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        savedDialog.setContentView(R.layout.dialog_saved)
        savedDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val delayMillis = 2000L // 2 seconds
        savedDialog.show()
        savedDialog.findViewById<View>(R.id.cardviewSaved).postDelayed({
            savedDialog.dismiss()
        }, delayMillis)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val toDialogEditProfile = view.findViewById<ConstraintLayout>(R.id.constraintEditProfile)
        toDialogEditProfile.setOnClickListener {
            showEditProfileDialog()
        }

        return view
    }
}