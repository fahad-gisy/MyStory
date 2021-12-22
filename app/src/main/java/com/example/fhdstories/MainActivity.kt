package com.example.fhdstories

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null
    private var navigationView: NavigationView? = null
    private var recyclerView: RecyclerView? = null
    private var floatingActionButton: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("username")


        connectVs()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()

        try {
            updateEmail(email!!)
        }catch (e:RuntimeException){
            "error"
        }

        drawerClicks()
        openAddStoryActivity()
        disPlayStories()



    }

    private fun updateEmail(email: String) {
        val headerView = navigationView?.getHeaderView(0)
        val textViewEmail = headerView?.findViewById<TextView>(R.id.tvEmail)
        textViewEmail?.text = email
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
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
        recyclerView = findViewById(R.id.storiesRecyclerView)
        floatingActionButton = findViewById(R.id.buttonAdd)
    }

    private fun drawerClicks() {
        navigationView?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    finish()
                    val i = Intent(this, LoginActivity::class.java)
                    startActivity(i)

                    true
                }
                else -> true
            }
        }
    }

    private fun openAddStoryActivity() {
        floatingActionButton?.setOnClickListener {
            val i = Intent(this, AddStoryActivity::class.java)
            startActivity(i)
        }
    }

    private fun disPlayStories() {
        val storiesArray = ArrayList<Story>()
        storiesArray.add(Story(getString(R.string.title1),getString(R.string.subtitle1),getString(R.string.desc1)))
        storiesArray.add(Story("Second Story","Kotlin","this is my story am gonna show you how i learnt kotlin and android programming"))
        storiesArray.add(Story("Third Story","Kotlin","this is my story am gonna show you how i learnt kotlin and android programming"))

        val customAdapter = CustomAdapter (storiesArray,this)
        recyclerView?.adapter = customAdapter

        if (intent.getStringExtra("title") !=null){
            val title = intent.getStringExtra("title")
            val subTitle = intent.getStringExtra("subtitle")
            val desc = intent.getStringExtra("desc")

            val newStory = Story(title!!,subTitle!!,desc!!)

            storiesArray.add(newStory)

             customAdapter.notifyDataSetChanged()
        }

    }
}