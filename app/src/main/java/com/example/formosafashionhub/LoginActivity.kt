package com.example.formosafashionhub

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Signing in")
        progressDialog.setMessage("Please wait...")

        val loginToRegister : TextView = findViewById(R.id.mTvLogin)

        loginToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        val loginButton: Button = findViewById(R.id.mBtnLogin)
        loginButton.setOnClickListener {
            performLogin()
        }

    }
    private fun performLogin() {
        // Get input from the User
        val email: EditText = findViewById(R.id.mEdtEmailLogin)
        val password: EditText = findViewById(R.id.mEdtPasswordLogin)

        // null checks on input
        if(email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()
        progressDialog.show()


        auth.signInWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, navigate to the Main Activity
                    val user = auth.currentUser
                    if (user?.email == "franciswachirathiongo200@gmail.com" ){
                        val intent = Intent(this, AdminActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }


                    Toast.makeText(baseContext, "Signed in successfully",
                        Toast.LENGTH_SHORT)
                        .show()
                    progressDialog.dismiss()
                }

            }
            .addOnFailureListener {
                Toast.makeText(baseContext, it.localizedMessage,
                    Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()

            }
    }


}