package com.example.memoryleakdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.blankj.utilcode.util.ToastUtils
import java.lang.ref.WeakReference

class HandlerLeakSolveActivity : BaseActivity() {

    private val mHandler = MyHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_leak_solve)
        mHandler.sendEmptyMessageDelayed(1, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacksAndMessages(null)
    }

    class MyHandler(context: Context) : Handler(Looper.getMainLooper()) {

        private val mContext = WeakReference(context)

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            sendEmptyMessageDelayed(1, 3000)
            val context = mContext.get()
            Log.d("HandlerLeakSolveActivity", "handleMessage ${context == null}")
            context?.let {
                ToastUtils.showShort("hello")
            }
        }
    }
}