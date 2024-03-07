package com.ccyx.model;

import lombok.Data;

/**
 * 动态模版配置
 */
@Data
public class MainTemplateConfig {
//    默认值防止不填、为空导致报错

    /**
     * 是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = "ccyx";

    /**
     * 输出信息
     * 次字符串变量空值会报错
     */
    private String outputText = "sum = ";
}
