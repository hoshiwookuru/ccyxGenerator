package com.ccyx.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.ccyx.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;
import java.util.Map;

//注解定义类为命令行工具类
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    public void run() {
        // 实现 config 命令的逻辑
        System.out.println("查看参数信息");

        //hutool反射工具类，拿到所有字段信息
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        // 遍历并打印每个字段的信息
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
//            System.out.println("Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }
    }
}
