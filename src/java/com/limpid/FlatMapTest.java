package com.limpid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * @ClassName FlatMapTest
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-09-18 22:28
 */
public class FlatMapTest {
    
    public static void main(String[] args) {
//        List<String> stringList = Arrays.asList("Hello", "World");
//        stringList.stream()
//                .map(world -> world.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList()).forEach(System.out::println);


        System.out.println(Stream.of(1, 2, 3, 4, 5).collect(counting()));
        System.out.println(Stream.of(1, 2, 3, 4, 5).count());

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().reduce(0, (a, b) -> a + b));

        integers.stream().reduce(0, Integer::sum);

    }
    
}
