package com.example.shihab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        btnLogin.setOnClickListener{
            login();
        }
    }
    private fun login(){
        val email = etEmailAddress.text.toString()
       val password = etPassword.text.toString();

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(this,"Email/password cannot be empty",Toast.LENGTH_SHORT).show()
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email, password.toString()).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


