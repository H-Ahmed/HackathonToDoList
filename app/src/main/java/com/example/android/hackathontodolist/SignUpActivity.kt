package com.example.android.hackathontodolist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.content_login.*

class SignUpActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(toolbar)
        mAuth = FirebaseAuth.getInstance()


    }

    private fun register() {
        var email2 = email.text.toString()
        var password2 = password.text.toString()

        if (!email2.isEmpty() && !password2.isEmpty()) {
            mAuth?.createUserWithEmailAndPassword(email2, password2)?.addOnCompleteListener({ task ->

                startActivity(Intent(applicationContext, SignUpActivity::class.java));

            });
        }
    }
}
