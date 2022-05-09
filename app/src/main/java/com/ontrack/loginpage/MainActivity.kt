package com.ontrack.loginpage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "login"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val sharedPreference:SharedPreferences=this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val et_user_name = findViewById<EditText>(R.id.et_user_name)
        val et_password = findViewById<EditText>(R.id.et_password)
        val btn_reset = findViewById<Button>(R.id.btn_reset)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        val signupBtn = findViewById<Button>(R.id.btn_signup)

        btn_reset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            et_user_name.setText("")
            et_password.setText("")
        }
        signupBtn.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
            finish()
        }

        // set on-click listener
        btn_submit.setOnClickListener {
            val s_user_name = et_user_name.text;
            val s_password = et_password.text;
            if(s_user_name.equals("") || s_password.equals("")){
                Toast.makeText(this,"Please Enter Details.",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val user_name = sharedPreference!!.getString("name_key","")
                val password = sharedPreference!!.getString("password","")

                Log.d("Soniya", "onCreate: "+user_name+password)

                if(user_name.equals(user_name) && password.equals(password)){

                    Toast.makeText(this@MainActivity, "login sucessfully", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                }else {
                    Toast.makeText(this,"User Not Available.",Toast.LENGTH_SHORT).show()
                }
            }
        }

            // your code to validate the user_name and password combination
            // and verify the same

        }
    }

