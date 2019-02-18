package com.limpid;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8新特性之Stream流操作
 *
 * @auther cuiqiongyu
 * @create 2018/12/25 14:31
 */
public class Feature5Stream {

    public static void main(String[] args) {
        /**
         * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
         * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
         * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
         * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
         * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
         * +--------------------+       +------+   +------+   +---+   +-------+
         * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
         * +--------------------+       +------+   +------+   +---+   +-------+
         */

        /**
         * 什么是 Stream？
         * Stream（流）是一个来自数据源的元素队列并支持聚合操作
         * 1. 元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
         * 2. 数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
         * 3. 聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
         * 和以前的Collection操作不同， Stream操作还有两个基础的特征：
         * 1. Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。
         * 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。
         * 2. 内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。
         * Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。
         */

        /**
         * 生成流？
         * 在 Java 8 中, 集合接口有两个方法来生成流：
         * 1. stream() − 为集合创建串行流。
         * 2. parallelStream() − 为集合创建并行流。
         */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        /**
         * forEach
         * Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
         */
        Random random = new Random();
        random.ints(0, 10).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println("");

        /**
         * map
         * map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
         */
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(collect);

        /**
         * filter
         * filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
         */
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings1.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        /**
         * limit
         * limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
         */
        Random random1 = new Random();
        random1.ints().limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println("");

        /**
         * sorted
         * sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序：
         */
        Random random2 = new Random();
        random2.ints().limit(10).sorted().forEach(i -> System.out.print(i + " "));
        System.out.println("");

        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");

        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f).andThen(f).andThen(f).accept("test1");

        // 测试stream流的各种创建方式
        testStreamCreator();
    }

    /**
     * 测试stream流的各种创建方式
     */
    private static void testStreamCreator() {
        // 1、创建空的Stream
        Stream empty = Stream.empty();
        System.out.println(empty);

        // 2、通过集合类中的stream或者parallelStream方法创建；
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().sorted((Integer o1, Integer o2) -> o2.compareTo(o1)).forEach(System.out::print);
        System.out.println();
        list.parallelStream().sorted((Integer o1, Integer o2) -> o2.compareTo(o1)).forEach(System.out::print);
        System.out.println();
        List<Integer> list2 = list.parallelStream().sorted((Integer o1, Integer o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        list2.stream().forEach(System.out::print);
        System.out.println();

        // 3、通过Stream中的of方法创建：
        Stream.of("a").forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sorted((Integer i, Integer j) -> j.compareTo(i)).forEach(System.out::print);
        System.out.println();

        /**
         * 4、通过Stream中的iterate方法创建：
         * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f);
         */
        Stream.iterate(1, i -> i * 2).limit(30).forEach(System.out::println);
        System.out.println(Stream.iterate(1, i -> i * 2).limit(5).mapToInt(i -> i).sum());
        System.out.println();

        // 5、通过Stream中的generate方法创建
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
        System.out.println();
        new Random().ints(10, 20).limit(10).forEach(System.out::println);
        System.out.println();

        // 6、通过Stream中的concat方法连接两个Stream对象生成新的Stream对象
        Stream.concat(Stream.generate(() -> Math.random()).limit(10), Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).forEach(System.out::println);
    }

}
