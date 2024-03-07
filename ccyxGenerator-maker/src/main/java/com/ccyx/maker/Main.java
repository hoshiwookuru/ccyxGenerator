package com.ccyx.maker;

import com.ccyx.maker.generator.main.GenerateTemplate;
import com.ccyx.maker.generator.main.MainGenerator;
import com.ccyx.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, TemplateException {
//        GenerateTemplate generateTemplate = new MainGenerator();
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}
