package com.example.shihab.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shihab.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_intro.*

class LoginIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)

        val auth = FirebaseAuth.getInstance(); //if he/she already logged in our system then we will get info from this
        if (auth.currentUser != null){
            Toast.makeText(this,"User already Logged In!",Toast.LENGTH_SHORT).show();
            redirect("MAIN");
        }

        btnGetStarted.setOnClickListener {
            redirect("LOGIN")

        }
    }

    private fun redirect(name:String){
        val intent = when(name){
            "LOGIN" -> Intent(this, LoginActivity::class.java)
            "MAIN" ->  Intent(this, MainActivity::class.java)
            else -> throw Exception("No path exists");
        }
        startActivity(intent)
        finish();
    }
}