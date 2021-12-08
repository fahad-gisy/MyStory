package com.example.fhdstories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    var drawer:DrawerLayout? = null
    var toolbar:Toolbar? = null
    private var navigationView:NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("username")
       connectVs()
      setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
        updateEmail(email!!)
        drawerClicks()
    }
private fun updateEmail(email:String){
    val headerView = navigationView?.getHeaderView(0)
    val textViewEmail = headerView?.findViewById<TextView>(R.id.tvEmail)
    textViewEmail?.text = email
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
        navigationView = findViewById(R.id.navView)
    }

    private  fun  drawerClicks(){
        navigationView?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout ->{
                    finish()
                    val i = Intent(this,LoginActivity::class.java)
                    startActivity(i)

                    true
                }
                else -> true
            }
        }
    }
}