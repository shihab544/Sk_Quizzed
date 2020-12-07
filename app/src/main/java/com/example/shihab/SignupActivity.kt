package com.example.shihab

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
            firebaseAuth = FirebaseAuth.getInstance();
            btnSignUp.setOnClickListener{
                signUpUser()
            }
        }

        private fun signUpUser() {
            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etCofirmPassword.text.toString()

            if(email.isBlank() || password.isBlank() || confirmPassword.isBlank()){
                Toast.makeText(this,"Email and Password required!",Toast.LENGTH_SHORT).show()
                return
            }
            if (password != confirmPassword){
                Toast.makeText(this,"Password Not Match!",Toast.LENGTH_SHORT).show();
                return
            }

            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Error creating user.",Toast.LENGTH_SHORT).show();
                }


            }



        }   }
