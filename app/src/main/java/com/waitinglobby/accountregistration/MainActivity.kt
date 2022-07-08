package com.waitinglobby.accountregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSpinnerList()
        button_submit.setOnClickListener {
            onSubmitClicked()
        }
    }

    private fun setSpinnerList() {
        val spinnerValues: Array<String> = arrayOf("None","Mr.","Mrs.", "Sr.", "Jr.")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        spinner_suffix.adapter = spinnerAdapter
    }

    private fun onSubmitClicked() {
        val account = Account(
            text_input_edit_text_username.text.toString(),
            text_input_edit_text_first_name.text.toString(),
            text_input_edit_text_last_name.text.toString(),
            spinner_suffix.selectedItem.toString(),
            text_input_edit_text_email.text.toString(),
            text_input_edit_phone.text.toString()
        )

        val accountSummaryIntent = Intent (this, AccountSummaryActivity::class.java)
        accountSummaryIntent.putExtra("Account", account)
        startActivity(accountSummaryIntent)
    }
}