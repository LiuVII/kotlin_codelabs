package com.example.mpyblake.helloworldapp
import android.app.Activity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.textView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.mpyblake.helloworldapp.R.id.textView

class MainActivity : AppCompatActivity() {


    val Num_Request = 1

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("count", textView.text.toString())
        Log.i("MainActivity","DataSaved")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MainActivity","SavedDataRestored")
        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString("count")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity","Create")
        //if (savedInstanceState != null) {
        //    textView.text = savedInstanceState.getString("count")
        //}
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity","Restart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","Resume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","Destroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","Pause")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","Start")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","Stop")
    }

    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello, My Emperor!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe (view: View) {

        // Get the value of the text view.
        val countString = textView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        // Display the new value in the text view.
        textView.text = count.toString();
    }

    fun randomMe(view: View) {

        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        // Get the value of the text view.
        val countString = textView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivityForResult(randomIntent, Num_Request)
    }

    fun intentMe(view: View) {

        // Create an Intent to start the second activity
        val impIntent = Intent(this, ImplicitIntent::class.java)

        // Start the new activity.
        startActivity(impIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && requestCode == Num_Request && resultCode == Activity.RESULT_OK) {
            val countString = data.getStringExtra(SecondActivity.EXTRA_REPLY)
            val newcount = Integer.parseInt(countString)
            textView.text = newcount.toString()
        }
    }
}
