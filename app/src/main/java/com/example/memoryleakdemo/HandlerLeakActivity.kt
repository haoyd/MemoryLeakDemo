package com.example.memoryleakdemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

/**
 * handler 造成内存泄露
 * @property tag String
 * @property mHandler <no name provided>
 */
class HandlerLeakActivity : BaseActivity() {

    private val mHandler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            sendEmptyMessageDelayed(1, 3000)
            Log.d(tag, "handleMessage")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_leak)
        mHandler.sendEmptyMessageDelayed(1, 3000)
    }
}