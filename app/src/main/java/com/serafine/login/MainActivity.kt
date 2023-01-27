package com.serafine.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnSignin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.email)
        edtPassword = findViewById(R.id.password)
        btnSignin = findViewById(R.id.signin)

        btnSignin.setOnClickListener(this)
    }
    fun isEmailValid(email: CharSequence): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onClick(v: View?) {
        var isEmptyEmail: Boolean = false
        var isEmail: Boolean = false
        var isEmptyPassword: Boolean = false

        if(edtEmail.text.toString().trim().length == 0){
            edtEmail.error = "Email harus diisi"
            isEmptyEmail = true
        }
        else if(isEmailValid(edtEmail.text) == false){
            edtEmail.error = "Email tidak vaid"
            isEmail = true
        }
        if (edtPassword.text.toString().trim().length == 0){
            edtPassword.error = "Password harus diisi"
            isEmptyPassword = true
        }
        if (!isEmptyEmail && !isEmail && !isEmptyPassword){
            val moveIntent = Intent(this@MainActivity, login::class.java)
            val email = edtEmail.text.toString()
            moveIntent.putExtra("String", email)
            startActivity(moveIntent)
        }
    }
}