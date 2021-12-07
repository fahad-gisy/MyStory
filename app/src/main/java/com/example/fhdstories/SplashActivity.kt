package com.example.fhdstories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLogin()
    }

    private fun moveToLogin() {
        //تاخر الانتقال ب الاملي سكند
        Handler(Looper.myLooper()!!).postDelayed({
            finish()//تستخدم ل حذف الواجهةة او قتل الكود يعني
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
        },3000)


        }
}