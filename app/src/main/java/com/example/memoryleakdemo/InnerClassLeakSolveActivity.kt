package com.example.memoryleakdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

class InnerClassLeakSolveActivity : AppCompatActivity() {

    companion object {
        private var testModule: WeakReference<TestModule>? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inner_class_leak_solve)

        testModule = WeakReference(TestModule())
    }

    inner class TestModule
}