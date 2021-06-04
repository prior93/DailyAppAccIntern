package com.example.dailyquizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        buLogin.setOnClickListener {
            login()
        }

        buSignup1.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }


    }


    private fun login(){
        val loginEmail = etloginEmail.text.toString()
        val loginPassword = etloginPassword.text.toString()

        if (loginEmail.isBlank() || loginPassword.isBlank()){
            Toast.makeText(this, "Email/password cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }//:Login function

        firebaseAuth.signInWithEmailAndPassword(loginEmail,loginPassword)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, QuestionActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
                }
            }


    }

}