package com.serafine.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class login : AppCompatActivity() {
    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        text = findViewById(R.id.text)

        val email = intent.getStringExtra("String")
        if(email != null){
            text.text = email
        }
    }
}