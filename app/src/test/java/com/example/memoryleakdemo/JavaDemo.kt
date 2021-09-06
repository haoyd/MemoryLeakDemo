package com.example.memoryleakdemo

fun main(args: Array<String>) {
    GCRoot1()
}

private fun divide() {
    println("------------------------------------------------------------------------")
}

class GCRoot1 {

    init {
        objTest()
        System.gc()
        println("第2次GC完成")
    }

    private fun objTest() {
        val memory = BigMemory(10)
        System.gc()
        println("第1次GC完成")
    }
}