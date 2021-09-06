package com.example.memoryleakdemo

class BigMemory(mbSize: Int) {
    private val memory = ByteArray(mbSize * 1024 * 1024)
}