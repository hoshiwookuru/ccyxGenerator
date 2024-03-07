package com.ccyx.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.ccyx.generator.MainGenerator;
import com.ccyx.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * 生成命令
 */

//注解定义类为命令行工具类
@Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
@Data
//需要交互式选择callable 不需要可以runnable
public class GenerateCommand implements Callable<Integer> {

    //interactive 设置交互式，echo设置为true使得在jar包运行中输入内容可见
    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author = "ccyx";

    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText = "sum = ";

    public Integer call() throws Exception {
        //创建动态模版
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        //复制对象属性，从当前对象（类）复制到mainTemplateConfig
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息：" + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}