package com.ccyx.generator;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成
 */

public class StaticGenerator {

    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     *
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        /*
        复制文件或目录 如果目标文件为目录，则将源文件以相同文件名拷贝到目标目录
        srcPath – 源文件或目录
        destPath – 目标文件或目录，目标不存在会自动创建（目录、文件都创建）
        isOverride – 是否覆盖目标文件
         */
        FileUtil.copy(inputPath, outputPath, false);
    }

}
