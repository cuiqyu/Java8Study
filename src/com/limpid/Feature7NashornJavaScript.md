### java8新特性之Nashorn JavaScript引擎

#### Nashorn介绍：
1. Nashorn 一个 javascript 引擎。
2. 从JDK 1.8开始，Nashorn取代Rhino(JDK 1.6, JDK1.7)成为Java的嵌入式JavaScript引擎。Nashorn完全支持ECMAScript 5.1规范以及一些扩展。
3. 它使用基于JSR 292的新语言特性，其中包含在JDK 7中引入的 invokedynamic，将JavaScript编译成Java字节码。
4. 与先前的Rhino实现相比，这带来了2到10倍的性能提升。
#### JJS
jjs是个基于Nashorn引擎的命令行工具。它接受一些JavaScript源代码为参数，并且执行这些源代码。

例如，我们创建一个具有如下内容的sample.js文件：

    print('Hello World!');
打开控制台，输入以下命令：

    $ jjs sample.js    
以上程序输出结果为：

    Hello World!
#### jjs 交互式编程
打开控制台，输入以下命令：

    $ jjs
    jjs> print("Hello, World!")
    Hello, World!
    jjs> quit()
    >>
#### 传递参数
打开控制台，输入以下命令：

    $ jjs -- a b c
    jjs> print('字母: ' +arguments.join(", "))
    字母: a, b, c
    jjs> 
#### JavaScript 中调用 Java
以下实例演示了如何在 JavaScript 中引用 Java 类：

    var BigDecimal = Java.type('java.math.BigDecimal');
    function calculate(amount, percentage) {
       var result = new BigDecimal(amount).multiply(
       new BigDecimal(percentage)).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_EVEN);
       return result.toPlainString();
    }
    var result = calculate(568000000000000000023,13.9);
    print(result);
我们使用 jjs 命令执行以上脚本，输出结果如下：

    $ jjs sample.js
    78952000000000002017.94
