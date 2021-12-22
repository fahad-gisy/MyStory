package com.example.fhdstories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class AddStoryActivity : AppCompatActivity() {

    private var editTextTitle:EditText? = null
    private var editTextSubTitle:EditText? = null
    private var editTextDesc:EditText? = null
    private var buttonAddStory:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)
        connectVs()
        fieldsValidaton()
    }


    private fun connectVs() {
       editTextTitle = findViewById(R.id.etTitle)
        editTextSubTitle = findViewById(R.id.etsubTitle)
        editTextDesc = findViewById(R.id.enterDescription)
        buttonAddStory = findViewById(R.id.buttonStoryAdd)
    }

    private fun fieldsValidaton() {
        buttonAddStory?.setOnClickListener {
            val title = editTextTitle?.text.toString()
            val subTitle = editTextSubTitle?.text.toString()
            val desc = editTextDesc?.text.toString()

            when {
                title.isEmpty() -> {
                    editTextTitle?.error = getString(R.string.enter_title)
                }
                subTitle.isEmpty() -> {
                    editTextSubTitle?.error = getString(R.string.enter_subtitle)
                }
                desc.isEmpty() -> {
                    editTextDesc?.error = getString(R.string.enter_desc)
                }
                else ->{
                    val i = Intent(this,MainActivity::class.java)
                    this.finish()
                    i.putExtra("title",title)
                       i.putExtra("subtitle",subTitle)
                        i.putExtra("desc",desc)
                         startActivity(i)
                }
            }

        }
    }

}