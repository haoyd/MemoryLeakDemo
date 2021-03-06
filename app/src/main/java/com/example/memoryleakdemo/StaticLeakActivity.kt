package com.example.memoryleakdemo

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast

class StaticLeakActivity : BaseActivity() {

    companion object {
        var mContext: Context? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_leak)
        mContext = this
    }

    fun toast(view: View) {
        Toast.makeText(mContext, "hello world", Toast.LENGTH_SHORT).show()
    }
}