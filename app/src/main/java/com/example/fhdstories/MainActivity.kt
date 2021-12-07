package com.example.fhdstories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    var drawer:DrawerLayout? = null
    var toolbar:Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("username")
       connectVs()
      setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
        drawer?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawer?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }

    private fun connectVs() {
       drawer = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
    }
}