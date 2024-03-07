package com.ccyx.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

//注解定义类为命令行工具类
@Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    public void run() {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        //TODO 在整体项目中打开，user.dir不需要再上一层
        parentFile = new File(projectPath);
        // 输入路径
        String inputPath = new File(parentFile, "ccyxGenerator-demo-projects/acm-template").getAbsolutePath();
        //loopFiles 自动遍历所有文件列表
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }

}