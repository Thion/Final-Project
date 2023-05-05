package com.example.formosafashionhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.formosafashionhub.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var welcomeTextView: TextView
    lateinit var categoriesButton: Button
    lateinit var contactUsButton: Button
    lateinit var signOutButton: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeTextView = findViewById(R.id.mTvWelcome)
        categoriesButton = findViewById(R.id.mBtnCategories)
        contactUsButton = findViewById(R.id.mBtnContactUs)
        signOutButton = findViewById(R.id.mBtnSignOut)

        categoriesButton.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)

        }
        contactUsButton.setOnClickListener {
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)

        }
        signOutButton.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }

    }
}