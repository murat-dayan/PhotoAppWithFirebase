package com.example.benimfotouyg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val guncelKullanici = auth.currentUser

        if (guncelKullanici != null){
            val intent = Intent(this , PostsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun girisYap(view:View){

        val email = email_text.text.toString()
        val sifre = sifre_text.text.toString()

        auth.signInWithEmailAndPassword(email , sifre).addOnCompleteListener { task ->
            if (task.isSuccessful){
                val guncelKullanici = auth.currentUser!!.email.toString()
                Toast.makeText(applicationContext , "Hoşgeldiniz ${guncelKullanici}" , Toast.LENGTH_LONG).show()

                val intent = Intent(this , PostsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext , exception.localizedMessage , Toast.LENGTH_LONG).show()
        }

    }

    fun kayitOl(view: View){

        val email = email_text.text.toString()
        val sifre = sifre_text.text.toString()

        auth.createUserWithEmailAndPassword(email , sifre).addOnCompleteListener { task ->
            if (task.isSuccessful){

                val intent = Intent(this , PostsActivity::class.java)
                startActivity(intent)
                finish()

            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext , exception.localizedMessage , Toast.LENGTH_LONG).show()
        }

    }
}