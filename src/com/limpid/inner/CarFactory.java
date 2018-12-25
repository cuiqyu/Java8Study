package com.limpid.inner;

/**
 * @auther cuiqiongyu
 * @create 2018/12/24 17:24
 */
public class CarFactory implements Vehicle, FourWheeler {

    @Override
    public void print() {
        Vehicle.super.print(); // 默认方法
        FourWheeler.super.print(); // 默认方法
        Vehicle.blowHorn(); // 静态方法
    }

    @Override
    public void test() {
        System.out.println("我实现了test方法");
    }

}
