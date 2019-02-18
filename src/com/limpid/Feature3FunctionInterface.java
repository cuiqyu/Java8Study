package com.limpid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * java8新特性之函数型接口学习
 *
 * @auther cuiqiongyu
 * @create 2018/12/24 16:24
 */
public class Feature3FunctionInterface {

    public static void main(String[] args) {
        /**
         * 说明：
         * 1. 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
         * 2. 函数式接口可以被隐式转换为 lambda 表达式。
         */

        /**
         * 例1：使用Lambda表达式来表示某函数型接口的一个实现
         */
        GreetingService greetingService1 = message -> {
            System.out.println("Hello " + message);
        };
        greetingService1.sayMessage("Java8");

        /**
         * java8新增的函数型接口
         * 1、BiConsumer<T,U>：代表了一个接受两个输入参数的操作，并且不返回任何结果
         */
        BiConsumer<Integer, Integer> biConsumer = (Integer t, Integer u) -> {
            System.out.println("入参一：" + t);
            System.out.println("入参二：" + u);
        };
        biConsumer.accept(1, 2);

        /**
         * 2、BiFunction<T,U,R>：代表了一个接受两个输入参数的方法，并且返回一个结果
         */
        BiFunction<Integer, Integer, Integer> addFunction = (Integer a, Integer b) -> {
            return a + b;
        };
        Integer result = addFunction.apply(1, 2);
        System.out.println(result);

        /**
         * 3、BinaryOperator<T>：代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
         */
        BinaryOperator<Integer> binaryOperator = (Integer a, Integer b) -> {
            System.out.println("3、BinaryOperator<T>：代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果 入参一：" + a + " 入参二：" + b + " 结果：" + (a - b));
            return a - b;
        };
        binaryOperator.apply(1, 2);
        BinaryOperator<Integer> compareMoreThan = BinaryOperator.maxBy((Integer o1, Integer o2) -> o1.compareTo(o2));
        Integer max = compareMoreThan.apply(5, 3);
        System.out.println("    3.1、BinaryOperator<T>.maxBy()：代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的最大值的结果 入参一：" + 5 + " 入参二：" + 3 + " 结果：" + max);
        BinaryOperator<Integer> compareLessThan = BinaryOperator.minBy((Integer o1, Integer o2) -> o1.compareTo(o2));
        Integer min = compareLessThan.apply(5, 3);
        System.out.println("    3.2、BinaryOperator<T>.minBy()：代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的最小值的结果 入参一：" + 5 + " 入参二：" + 3 + " 结果：" + min);

        /**
         * 4、BiPredicate<T,U>：代表了一个两个参数的boolean值方法
         */
        BiPredicate<String, Integer> biPredicate = (String s, Integer i) -> {
            System.out.println("4、BiPredicate<T,U>：代表了一个两个参数的boolean值方法 入参一：" + s + " 入参二：" + i + " 结果：" + (s.equals("Hello") && i % 2 == 0));
            return s.equals("Hello") && i % 2 == 0;
        };
        biPredicate.test("Hello", 2);

        /**
         * 5、BooleanSupplier：代表了boolean值结果的提供方
         */
        BooleanSupplier booleanSupplier = () -> {
            System.out.println("5、BooleanSupplier：代表了boolean值结果的提供方 结果：" + true);
            return true;
        };
        booleanSupplier.getAsBoolean();

        /**
         * 6、Consumer<T>：代表了接受一个输入参数并且无返回的操作
         */
        Consumer<Integer> consumer = (Integer i) -> {
            System.out.println("6、Consumer<T>：代表了接受一个输入参数并且无返回的操作 入参：" + i);
        };
        consumer.accept(3);

        /**
         * 7、DoubleBinaryOperator：代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。
         */
        DoubleBinaryOperator doubleBinaryOperator = (double a, double b) -> {
            System.out.println("7、DoubleBinaryOperator：代表了作用于两个double值操作符的操作，并且返回了一个double值的结果 入参一：" + a + " 入参二：" + b + " 结果：" + (a * b));
            return a * b;
        };
        doubleBinaryOperator.applyAsDouble(1.9, 3.0);

        /**
         * 8、DoubleConsumer：代表一个接受double值参数的操作，并且不返回结果。
         */
        DoubleConsumer doubleConsumer = (double a) -> {
            System.out.println("8、DoubleConsumer：代表一个接受double值参数的操作，并且不返回结果 入参：" + a);
        };
        doubleConsumer.accept(3.0);

        /**
         * 9、DoubleFunction<R>：代表接受一个double值参数的方法，并且返回结果
         */
        DoubleFunction<Integer> doubleFunction = (double r) -> {
            System.out.println("9、DoubleFunction<R>：代表接受一个double值参数的方法，并且返回结果 入参：" + r + " 结果：" + (int) Math.round(r));
            return (int) Math.round(r);
        };
        doubleFunction.apply(3.6);

        /**
         * 10、DoublePredicate：代表一个拥有double值参数的boolean值方法
         */
        DoublePredicate doublePredicate = (double d) -> {
            System.out.println("10、DoublePredicate：代表一个拥有double值参数的boolean值方法 入参：" + d + " 结果：" + (d > 3.0));
            return d > 3.0;
        };
        doublePredicate.test(4.3);

        /**
         * 11、DoubleSupplier：代表一个double值结构的提供方
         */
        DoubleSupplier doubleSupplier =  () -> {
            System.out.println("11、DoubleSupplier：代表一个double值结构的提供方 结果：" + 3.0);
            return 3.0;
        };
        doubleSupplier.getAsDouble();

        /**
         * 12、DoubleToIntFunction：接受一个double类型输入，返回一个int类型结果。
         */
        DoubleToIntFunction doubleToIntFunction = (double d) -> {
            System.out.println("12、DoubleToIntFunction：接受一个double类型输入，返回一个int类型结果 入参：" + d + " 结果：" + (int) Math.round(d));
            return (int) Math.round(d);
        };
        doubleToIntFunction.applyAsInt(6.3);

        /**
         * 13、DoubleToLongFunction：接受一个double类型输入，返回一个long类型结果
         */
        /**
         * 14、DoubleUnaryOperator：接受一个参数同为类型double,返回值类型也为double 。
         */
        /**
         * 15、Function<T,R>：接受一个输入参数，返回一个结果。
         */
        /**
         * 16、IntBinaryOperator：接受两个参数同为类型int,返回值类型也为int。
         */
        /**
         * 17、IntConsumer：接受一个int类型的输入参数，无返回值 。
         */
        /**
         * 18、IntFunction<R>：接受一个int类型输入参数，返回一个结果 。
         */
        /**
         * 19、IntPredicate：接受一个int输入参数，返回一个布尔值的结果。
         */
        /**
         * 20、IntSupplier：无参数，返回一个int类型结果。
         */
        /**
         * 21、IntToDoubleFunction：接受一个int类型输入，返回一个double类型结果 。
         */
        /**
         * 22、IntToLongFunction：接受一个int类型输入，返回一个long类型结果。
         */
        /**
         * 23、IntUnaryOperator：接受一个参数同为类型int,返回值类型也为int 。
         */
        /**
         * 24、LongBinaryOperator：接受两个参数同为类型long,返回值类型也为long。
         */
        /**
         * 25、LongConsumer：接受一个long类型的输入参数，无返回值。
         */
        /**
         * 26、LongFunction<R>：接受一个long类型输入参数，返回一个结果。
         */
        /**
         * 27、LongPredicate：R接受一个long输入参数，返回一个布尔值类型结果。
         */
        /**
         * 28、LongSupplier：无参数，返回一个结果long类型的值。
         */
        /**
         * 29、LongToDoubleFunction：接受一个long类型输入，返回一个double类型结果。
         */
        /**
         * 30、LongToIntFunction：接受一个long类型输入，返回一个int类型结果。
         */
        /**
         * 31、LongUnaryOperator：接受一个参数同为类型long,返回值类型也为long。
         */
        /**
         * 32、ObjDoubleConsumer<T>：接受一个object类型和一个double类型的输入参数，无返回值。
         */
        /**
         * 33、ObjIntConsumer<T>：接受一个object类型和一个int类型的输入参数，无返回值。
         */
        /**
         * 34、ObjLongConsumer<T>：接受一个object类型和一个long类型的输入参数，无返回值。
         */
        /**
         * 35、Predicate<T>：接受一个输入参数，返回一个布尔值结果。
         */
        /**
         * 36、Supplier<T>：无参数，返回一个结果。
         */
        /**
         * 37、ToDoubleBiFunction<T,U>：接受两个输入参数，返回一个double类型结果
         */
        /**
         * 38、ToDoubleFunction<T>：接受一个输入参数，返回一个double类型结果
         */
        /**
         * 39、ToIntBiFunction<T,U>：接受两个输入参数，返回一个int类型结果。
         */
        /**
         * 40、ToIntFunction<T>：接受一个输入参数，返回一个int类型结果。
         */
        /**
         * 41、ToLongBiFunction<T,U>：接受两个输入参数，返回一个long类型结果。
         */
        /**
         * 42、ToLongFunction<T>：接受一个输入参数，返回一个long类型结果。
         */
        /**
         * 43、UnaryOperator<T>：接受一个参数为类型T,返回值类型也为T。
         */
        /**
         * 例2：使用默认的Predicate函数应用
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("输出所有的参数：");
        eval(list, n -> true);
        System.out.println("输出所有的偶数");
        eval(list, n -> n % 2 == 0);
        System.out.println("输出所有的奇数");
        eval(list, n -> n % 2 == 1);
        System.out.println("输出所有大于4的数");
        eval(list, n -> n > 4);
        /**
         * 例3：使用UnaryOperator实现一个求平方的功能
         */
        UnaryOperator<List<Integer>> toto = (List<Integer> paramList) -> {
            return paramList.stream().map(i -> i * i).collect(Collectors.toList());
        };
        List<Integer> apply = toto.apply(list);
        System.out.println(apply);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        /*list.forEach(n -> {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        });*/
        list.stream().filter(predicate).forEach(n -> System.out.print(n + " "));
        System.out.println("");
    }

}

/**
 * 定义函数型接口
 */
@FunctionalInterface
interface GreetingService {
    void sayMessage(String message);
}