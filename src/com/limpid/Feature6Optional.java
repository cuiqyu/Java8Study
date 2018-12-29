package com.limpid;

import java.util.Optional;

/**
 * java8新特性之学习Optional 类
 *
 * @auther cuiqiongyu
 * @create 2018/12/29 14:19
 */
public class Feature6Optional {

    public static void main(String[] args) {
        /**
         * Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
         * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
         * Optional 类的引入很好的解决空指针异常。
         */

        /**
         * Optional.ofNullable - 允许传递为 null 参数
         */
        Optional<Integer> a = Optional.ofNullable(null);
        Optional<Integer> b = Optional.ofNullable(1);
        /**
         * Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
         */
        Optional<Integer> c = Optional.of(3);

        System.out.println(sum(b, c));

    }

    public static Integer sum(Optional<Integer> b, Optional<Integer> c) {
        /**
         * Optional.isPresent - 判断值是否存在
         */
        System.out.println("第一个参数值存在: " + b.isPresent());
        System.out.println("第二个参数值存在: " + c.isPresent());

        /**
         * Optional.orElse - 如果值存在，返回它，否则返回默认值
         */
        Integer value1 = b.orElse(new Integer(0));
        Integer value2 = c.orElse(new Integer(0));

        return value1 + value2;
    }

}
