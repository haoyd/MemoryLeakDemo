package com.example.memoryleakdemo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    protected lateinit var tag: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tag = localClassName

        val title = intent?.getStringExtra("title")
        if (!TextUtils.isEmpty(title)) {
            setTitle(title)
        }
    }

    protected fun startPage(cls: Class<*>?, pageName: String) {
        val intent = Intent(this, cls)
        intent.putExtra("title", pageName)
        startActivity(intent)
    }

}