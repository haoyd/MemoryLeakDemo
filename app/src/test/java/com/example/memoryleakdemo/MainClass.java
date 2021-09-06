package com.example.memoryleakdemo;

import android.app.Activity;

public class MainClass {

    public static void main(String[] args) {
        m1();
        m1();
        System.out.println("hello");
    }

    private static void m1() {
        Dog dog = new Dog("旺财");
        System.out.println(dog.child.hashCode());
        dog = null;
        System.gc();
    }
}

class Dog {
    // 因为该类属于 Dog 类的全局属性（类属性），所以存在于方法区中，每个线程共享
    // 该类属性被 final 修饰，在第一次赋值后不允许更改，所以此对象可作为 GCRoot
    public static final Dog child = new Dog("小旺财");
    private String name;
    public Dog(String name) {
        this.name = name;
    }
}


