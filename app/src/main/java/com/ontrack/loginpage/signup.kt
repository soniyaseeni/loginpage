package com.ontrack.loginpage

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class signup : AppCompatActivity() {

    private val sharedPrefFile = "login"
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val name = findViewById<EditText>(R.id.name)
        val emailid = findViewById<EditText>(R.id.emial)
        val mobile = findViewById<EditText>(R.id.mobileno)
        val pass = findViewById<EditText>(R.id.pass)
        val save = findViewById<Button>(R.id.btn_save)
        val login = findViewById<Button>(R.id.log)


        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        save.setOnClickListener {
            val user_name = name.text;
            val email = emailid.text;
            val mobile = mobile.text;
            val password = pass.text;
            Toast.makeText(this@signup, "saved sucessfully", Toast.LENGTH_LONG).show()

            val name:String = name.text.toString()
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString("name_key",name)

            editor.apply()
            editor.commit()


        }

            }

        }
