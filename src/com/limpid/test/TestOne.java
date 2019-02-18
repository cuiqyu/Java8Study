package com.limpid.test;

import java.util.Arrays;
import java.util.List;

/**
 * @auther cuiqiongyu
 * @create 2019/1/23 10:04
 */
public class TestOne {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        /**
         * 查询数组中大于5的最小偶数
         */
        System.out.println(numbers.stream()
                .peek(System.out::println) // 方便调试
                // .parallel() // 开启多线程
                .filter(e -> e > 5) // 第一轮过滤
                .filter(e -> e % 2 == 0) // 第二轮过滤
                .findFirst() // 查询过滤后结果的第一个值
                .map(e -> "This is value:" + e) // 对象值映射
                .orElse("no value found")); // 未查询到择取这个值


        /**
         * 校验并行化
         */
        long startTime = System.currentTimeMillis();
        numbers.stream().forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i * 2);
        });
        System.out.println("总花费：" + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        numbers.stream().parallel().forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i * 2);
        });
        System.out.println("总花费：" + (System.currentTimeMillis() - startTime));

    }


}
