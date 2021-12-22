package com.example.fhdstories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Scroller
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetailsActivity2 : AppCompatActivity() {
    private var toolbar:Toolbar? = null
    private var storyDesc:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details2)
        connectVs()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        supportActionBar?.title = title
        toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }
        storyDesc?.text = desc
//        storyDesc?.movementMethod
    }
    private fun connectVs(){
      toolbar = findViewById(R.id.toolBar)
      storyDesc = findViewById(R.id.tvDesc)
    }
}