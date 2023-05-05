package com.example.formosafashionhub

import android.app.ProgressDialog
import android.app.ProgressDialog.show
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = Firebase.auth
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Signing up")
        progressDialog.setMessage("Please wait...")

        val registerToLogin: TextView = findViewById(R.id.mTvRegister)

        registerToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.mBtnRegister)

        registerButton.setOnClickListener {
            performSignUp()
        }
        // let's get email and password from the user
    }

    private fun performSignUp() {
        val username = findViewById<EditText>(R.id.mEdtUsernameRegister)
        val email = findViewById<EditText>(R.id.mEdtEmailRegister)
        val password = findViewById<EditText>(R.id.mEdtPasswordRegister)

        if (username.text.isEmpty() || email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val inputUsername = username.text.toString()
        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()
        progressDialog.show()

        auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, move to next activity
                    
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Signed up successfully",
                        Toast.LENGTH_SHORT)
                        .show()
                    finish()
                    progressDialog.dismiss()

                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.localizedMessage,Toast.LENGTH_SHORT)
                    .show()
                progressDialog.dismiss()
            }

    }

}

