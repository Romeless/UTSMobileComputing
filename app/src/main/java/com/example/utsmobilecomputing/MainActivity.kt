package com.example.utsmobilecomputing

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.utsmobilecomputing.ui.home.HomeFragment
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        var title: String = "Counter"

        supportFragmentManager.beginTransaction().replace(R.id.app_main, HomeFragment())

        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_reset -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Reset Counter")
                    builder.setMessage("Are you sure you want to reset the counter?")
                        .setCancelable(true)
                        .setPositiveButton("Reset", DialogInterface.OnClickListener { _, _ ->
                            val counter: TextView = findViewById(R.id.textinput_counter)
                            counter.text = "0"
                        })
                        .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
                            dialog.cancel()
                        })
                    builder.create().show()

                    true
                }

                R.id.action_edit -> {
                    val view = layoutInflater.inflate(R.layout.edit_counter, null)
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Edit Counter")
                        .setView(view)
                        .setCancelable(true)
                        .setPositiveButton("Apply", DialogInterface.OnClickListener { _, _ ->
                            val counter: TextView = findViewById(R.id.textinput_counter)
                            val toolbar: Toolbar = findViewById(R.id.toolbar)
                            toolbar.title = view.findViewById<TextView>(R.id.title_edit).text.toString()
                            counter.text = view.findViewById<TextView>(R.id.count_edit).text.toString()
                        })
                        .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
                            dialog.cancel()
                        })

                    builder.show()
                    true
                }

                else -> false
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}