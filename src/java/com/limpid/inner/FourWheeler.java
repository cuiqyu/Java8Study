package com.limpid.inner;

/**
 * @auther cuiqiongyu
 * @create 2018/12/24 17:22
 */
@FunctionalInterface
public interface FourWheeler {

    default void print() {
        System.out.println("我是一辆四轮车!");
    }

    void test();

}
