package com.example.mobile_desktopstage0task

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button_links)

        // set on click listener on the button
        button.setOnClickListener(){
            // show dialogs with link options
            showLinkOptions()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showLinkOptions() {
        // Array of link options
        val links = arrayOf("GitHub Repository", "HNG Kotlin Developers", "Telex", "Delve")
        // create and show the alert dialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("choose link to visit")
        builder.setItems(links) {dialog, which ->
            when (which) {
                0 -> openUrl("https://github.com/JamesWainaina/MOBILE-DESKTOP-STAGE-0-TASK")
                1 -> openUrl("http://hng.tech/hire/kotlin-developers")
                2 -> openUrl("https://telex.im/")
                3 -> openUrl("https://delve.fun/")
            }
        }
        builder.show()
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}