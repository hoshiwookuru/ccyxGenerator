package com.ccyx.maker.generator.main;

public class MainGenerator extends GenerateTemplate{

    @Override
    protected String buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        //重写了 buildDist ，下方main方法执行 doGenerate ，执行到 buildDist 时便执行此方法，所以dist被忽略了
        System.out.println("不要输出dist");
        return "";
    }
}
