package com.example.memoryleakdemo

import android.os.Bundle

class InnerClassLeakActivity : BaseActivity() {

    companion object {
        private var testModule: TestModule? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inner_class_leak)

        testModule = TestModule()
    }

    inner class TestModule
}