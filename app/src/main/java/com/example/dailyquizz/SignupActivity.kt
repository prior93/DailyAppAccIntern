package com.example.dailyquizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        firebaseAuth = FirebaseAuth.getInstance()


        buSignup.setOnClickListener {
            signUp()
        }

        buLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signUp() {

       val signupEmail = etloginEmail.text.toString()
        val signupPassword = etloginPassword.text.toString()
        val signupConfirmPassword = etloginConfirmPassword.text.toString()

        if (signupEmail.isBlank()||signupConfirmPassword.isBlank()||signupPassword.isBlank()){
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (signupPassword != signupConfirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }


        firebaseAuth.createUserWithEmailAndPassword(signupEmail,signupPassword)

            .addOnCompleteListener(this){

                if(it.isSuccessful){
                    Toast.makeText(this,"Account created  Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this, "Error creating user.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}