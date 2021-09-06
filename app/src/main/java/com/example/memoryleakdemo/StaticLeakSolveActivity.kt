package com.example.memoryleakdemo

import android.content.Context
import android.os.Bundle
import java.lang.ref.WeakReference

/**
 * 解决方案
 * 1、如果不是非常必要最好不要被静态所持有
 * 2、如果必须放到静态的位置，用虚引用持有
 */
var mContext1: WeakReference<Context>? = null

class StaticLeakSolveActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_leak_solve)
        mContext1 = WeakReference(this)
    }
}