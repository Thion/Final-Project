package com.example.formosafashionhub

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ContactUsActivity : AppCompatActivity() {
    lateinit var contactUsImageView: ImageView
    lateinit var callIcon: ImageView
    lateinit var emailIcon: ImageView
    lateinit var messageIcon: ImageView
    lateinit var phoneNoTextView: TextView
    lateinit var emailAddressTextView: TextView
    lateinit var messageUsTextView: TextView
    lateinit var actualPhoneNo: TextView
    lateinit var actualEmailAddress: TextView
    lateinit var actualMessageUs: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        contactUsImageView = findViewById(R.id.mIvContactUs)
        callIcon = findViewById(R.id.mIconCall)
        emailIcon = findViewById(R.id.mIconEmail)
        messageIcon = findViewById(R.id.mIconMessage)
        phoneNoTextView = findViewById(R.id.mTvPhoneNo)
        emailAddressTextView = findViewById(R.id.mTvEmailAddress)
        messageUsTextView = findViewById(R.id.mTvMessageUs)
        actualPhoneNo = findViewById(R.id.mTvActualPhoneNo)
        actualEmailAddress = findViewById(R.id.mTvActualEmailAddress)
        actualMessageUs = findViewById(R.id.mTvActualMessageUs)
        actualPhoneNo.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707983555"))
            if (ContextCompat.checkSelfPermission(
                    this@ContactUsActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@ContactUsActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        actualEmailAddress.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "franciswachirathiongo200@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Dear Sir, following..."))
        }

        actualMessageUs.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0707983555")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello there")
            startActivity(intent)
        }


    }
}