package com.example.mpyblake.helloworldapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast

class ImplicitIntent : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        Log.i("ImplicitIntent","Create")
        val e1 = findViewById(R.id.urlEditText) as EditText
        registerForContextMenu(e1)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when(v?.id) {
            R.id.urlEditText -> menuInflater.inflate(R.menu.cont1_menu, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.cm1 -> Toast.makeText(this, "You selected the FIRST item", Toast.LENGTH_SHORT).show()
            R.id.cm2 -> Toast.makeText(this, "You selected the SECOND item", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    fun webMe (view: View) {

        val e1 = findViewById(R.id.urlEditText) as EditText
        var uriString = e1.text.toString()
        if (uriString.isNotEmpty()) {
            if (uriString.length < 8 || (uriString.substring(7) != "http://" &&
                    uriString.substring(8) != "https://"))
                uriString = "http://" + uriString
        }
        else {
            Toast.makeText(this, "Empty url request", Toast.LENGTH_SHORT).show()
            return
        }
        val iMe = Intent(Intent.ACTION_VIEW, Uri.parse(uriString))
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
