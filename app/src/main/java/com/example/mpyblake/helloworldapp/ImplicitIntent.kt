package com.example.mpyblake.helloworldapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.View

class ImplicitIntent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        Log.i("ImplicitIntent","Create")
    }

    fun webMe (view: View) {

        val iMe = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.42.us.org/"))
        if (iMe.resolveActivity(packageManager) != null) {
            startActivity(iMe)
        }
    }

    fun callMe (view: View) {

        val iMe = Intent(Intent.ACTION_VIEW, Uri.parse("tel:+79265815179"))
        if (iMe.resolveActivity(packageManager) != null) {
            startActivity(iMe)
        }
    }

    fun mapMe (view: View) {

        val iMe = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.786971,-122.399677"))
        if (iMe.resolveActivity(packageManager) != null) {
            startActivity(iMe)
        }
    }
}
