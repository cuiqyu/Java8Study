package com.limpid;

//import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * 兑取配置文件
 *
 * @auther cuiqiongyu
 * @create 2019/2/18 14:34
 */
public class Loadsetting {

    public static void main(String[] args) {

        ClassLoader classLoader = Loadsetting.class.getClassLoader();
        // 使用classloadder读取properties配置文件
        InputStream resourceAsStream = classLoader.getResourceAsStream("user.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.keySet().forEach((s) -> {
            System.out.println(s + ":" + properties.getProperty((String) s));
        });
        System.out.println();

/*        // 使用classloader读取yml配置文件
        InputStream resourceAsStream1 = classLoader.getResourceAsStream("user.yml");
        Yaml yaml = new Yaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(resourceAsStream1);
        map.keySet().stream().forEach((s) -> {
            System.out.println(map.get(s));
        });*/

    }


}
