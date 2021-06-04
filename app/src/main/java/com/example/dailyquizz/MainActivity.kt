package com.example.dailyquizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(input.text.toString().isEmpty())
            {
                Toast.makeText(this,"Enter Your Name", Toast.LENGTH_LONG).show()
            }
            else {
                var intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish() // finish doesnt  allow to  come back to the Starting page
            }
        }


    }




}