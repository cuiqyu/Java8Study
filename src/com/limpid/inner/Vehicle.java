package com.limpid.inner;

/**
 * @auther cuiqiongyu
 * @create 2018/12/24 17:20
 */
@FunctionalInterface
public interface Vehicle {

    default void print() {
        System.out.println("我是一辆车!");
    }

    // java 8 的另一个特性是接口可以声明（并且可以提供实现）静态方法。例如：
    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }

    void test();

}
