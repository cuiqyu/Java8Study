package com.limpid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName FlatMapTest
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-09-18 22:28
 */
public class FlatMapTest {
    
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Hello", "World");
        stringList.stream()
                .map(world -> world.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()).forEach(System.out::println);

    }
    
}
