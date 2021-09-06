package com.example.memoryleakdemo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), AdapterView.OnItemClickListener {

    private val pages = listOf(
        "handler内存泄露 - 问题",
        "handler内存泄露 - 解决",
        "注册对象未注销 - 问题",
        "注册对象未注销 - 解决",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "主页"
        mListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pages)
        mListView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val title = pages[position]
        when (position) {
            0 -> {
                startPage(HandlerLeakActivity::class.java, title)
            }
            1 -> {
                startPage(HandlerLeakSolveActivity::class.java, title)
            }
            2 -> {
                startPage(ObserverLeakActivity::class.java, title)
            }
            3 -> {
                startPage(ObserverLeakSolveActivity::class.java, title)
            }
        }

    }
}