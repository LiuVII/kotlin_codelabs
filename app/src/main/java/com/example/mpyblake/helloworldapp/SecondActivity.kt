package com.example.mpyblake.helloworldapp
import android.app.Activity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_second.textview_random
import kotlinx.android.synthetic.main.activity_second.textview_label

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
        const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("random", textview_random.text.toString())
        Log.i("SecondActivity","DataSaved")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            textview_random.text = savedInstanceState.getString("random")
        }
        Log.i("SecondActivity","SavedDataRestored")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
        Log.i("SecondActivity","Create")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("SecondActivity","Restart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("SecondActivity","Resume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SecondActivity","Destroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i("SecondActivity","Pause")
    }

    override fun onStart() {
        super.onStart()
        Log.i("SecondActivity","Start")
    }

    override fun onStop() {
        super.onStop()
        Log.i("SecondActivity","Stop")
    }

    fun showRandomNumber() {

        // Get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

        // Generate the random number and rand function
        val random = Random()
        var randomInt = 0

        // Add one because the bound is exclusive
        if (count > 0) {
            // Add one because the bound is exclusive
            randomInt = random.nextInt(count + 1)
        }

        // Display the random number.
        textview_random.text = Integer.toString(randomInt)

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        textview_label.text = getString(R.string.random_heading, count)
    }

    fun resOk(view: View) {

        val replyIntent = Intent()
        val res = textview_random.text.toString()
        replyIntent.putExtra(EXTRA_REPLY, res)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }

    fun resCancel(view: View) {

        val replyIntent = Intent()
        setResult(Activity.RESULT_CANCELED, replyIntent)
        finish()
    }
}

