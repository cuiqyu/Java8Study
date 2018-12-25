package com.limpid;

import com.limpid.inner.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java8新特性之方法引用学习
 *
 * @auther cuiqiongyu
 * @create 2018/12/24 16:10
 */
public class Feature2MethodReference {

    public static void main(String[] args) {
        /**
         * 构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
         */
        final Car car1 = Car.create(Car::new);
        final Car car2 = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car1, car2);
        /**
         * 静态方法引用：它的语法是Class::static_method，实例如下：
         */
        cars.forEach(Car::collide);
        /**
         * 特定类的任意对象的方法引用：它的语法是Class::method实例如下：
         */
        cars.forEach(Car::repair);
        /**
         * 特定对象的方法引用：它的语法是instance::method实例如下：
         */
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

        /**
         * 例如System.out::println
         */
        List names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }

}
