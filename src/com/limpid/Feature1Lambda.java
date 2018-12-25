package com.limpid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * java8新特性之Lambda表达式学习
 *
 * @auther cuiqiongyu
 * @create 2018/12/24 15:56
 */
public class Feature1Lambda {

    public static void main(String[] args) {
        /**
         * lambda表达式的重要特征:
         * 1. 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值
         * 2. 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号
         * 3. 可选的大括号：如果主体包含了一个语句，就不需要使用大括号
         * 4. 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值
         *
         * 使用lambda表达式需要注意一下两点：
         * 1. Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口
         * 在下面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法
         * 2. Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力
         */
        // test1();
        // test2();

        /**
         * lambda表达式的内部不能修改外部变量
         * * lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
         * * 可以这么理解为什么这么设计，比如如果你没有使用lambda表达式，在调用接口的方法实现里面也是访问不到当前调用者的变量的，这个很好理解
         */
        // test3();

        /**
         * Lambda表达式当中不允许声明一个与局部变量同名的参数或者局部变量
         */

        /**
         * 使用lambda表达式来写排序
         */
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Feature1Lambda lambda = new Feature1Lambda();
        lambda.java7Sort(names1);

        lambda.java8Sort(names2);

    }

    public static void test1() {
        // 1. 不需要参数，直接返回结果
        // () -> 5
        Operate1 operate1 = () -> 5;
        System.out.println(operate1.method());

        // 2. 接受一个参数（数字类型），并返回它的2倍
        // x -> 2 * x;
        Operate2 operate2 = x -> 2 * x;
        System.out.println(operate2.method(2));

        // 3. 3. 接受2个参数(数字),并返回他们的差值
        // (x, y) -> (x - y);
        Operate3 operate3 = (x, y) -> (x - y);
        System.out.println(operate3.method(3, 1));

        // 4. 接收2个int型整数,返回他们的和
        // (x, y) -> (x + y);
        Operate4 operate4 = (int x, int y) -> {
            return x + y;
        };
        System.out.println(operate4.method(1, 2));

        // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
        // (String s) -> System.out.print(s);
        Operate5 operate5 = (s) -> {
            System.out.println(s);
        };
        operate5.method("Hello java8");
    }

    public static void test2() {
        MathOperation addition = (x, y) -> x + y;
        MathOperation subtraction = (x, y) -> x - y;
        MathOperation multiplication = (x, y) -> x * y;
        MathOperation division = (x, y) -> x / y;

        System.out.println(operate(1, 2, addition));
        System.out.println(operate(1, 2, subtraction));
        System.out.println(operate(1, 2, multiplication));
        System.out.println(operate(1, 2, division));
    }

    public static void test3() {
        String sayHello = "say Hello ";
        Operate5 operate5 = (s) -> {
            System.out.println(sayHello + s);
        };
        operate5.method("lambda");
    }

    interface Operate1 {
        int method();
    }

    interface Operate2 {
        int method(int i);
    }

    interface Operate3 {
        int method(int a, int b);
    }

    interface Operate4 {
        int method(int a, int b);
    }

    interface Operate5 {
        void method(String s);
    }

    interface MathOperation {
        int operate(int i, int j);
    }

    private static int operate(int i, int j, MathOperation mathOperation) {
        return mathOperation.operate(i, j);
    }

    private void java7Sort(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("使用java7的普通排序写法" + list);
    }

    private void java8Sort(List<String> list) {
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        System.out.println("使用java8的lambda排序写法" + list);
    }

    /**
     * java8新特性之函数型接口学习
     *
     * @auther cuiqiongyu
     * @create 2018/12/24 16:22
     */
    public static class Feature3FunctionInterface {

        public static void main(String[] args) {
            /**
             * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
             * 函数式接口可以被隐式转换为 lambda 表达式。
             * Lambda 表达式和方法引用（实际上也可认为是Lambda表达式）上。
             */
        }

    }
}
