package com.limpid.inner;

import java.util.function.Supplier;

/**
 * 声明汽车类
 * @auther cuiqiongyu
 * @create 2018/12/24 16:16
 */
public class Car {

    //Supplier是jdk1.8的函数型接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

}
