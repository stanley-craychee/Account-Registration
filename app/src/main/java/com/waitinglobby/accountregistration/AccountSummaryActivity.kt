package com.waitinglobby.accountregistration

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account_summary.*

class AccountSummaryActivity : AppCompatActivity() {

    private lateinit var account: Account
    private lateinit var fullName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_summary)
        setFields()
        setupPhoneLink()
        setupEmailLink()
    }

    private fun setupEmailLink() {
        text_view_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto: ${account.email}")
            }
            startActivity(intent)
        }
    }

    private fun setupPhoneLink() {
        text_view_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${account.phone}")
            }
            startActivity(intent)
        }
    }

    private fun setFields() {
        account = intent.getSerializableExtra("Account") as Account
        text_view_full_name.text = account.getFullName()
        text_view_username.text = account.username
        text_view_email.text = account.email
        text_view_phone.text = account.phone
    }
}