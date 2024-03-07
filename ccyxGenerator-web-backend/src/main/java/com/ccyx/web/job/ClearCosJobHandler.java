package com.ccyx.web.job;

import cn.hutool.core.util.StrUtil;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.ccyx.web.manager.CosManager;
import com.ccyx.web.mapper.GeneratorMapper;
import com.ccyx.web.model.entity.Generator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ClearCosJobHandler {

    @Resource
    private CosManager cosManager;

    @Resource
    private GeneratorMapper generatorMapper;

    /**
     * 每天执行
     *
     * @throws Exception
     */
    @XxlJob("clearCosJobHandler")
    public void clearCosJobHandler() throws Exception {
        log.info("clearCosJobHandler start");
        // 编写业务逻辑
        // 1. 包括用户上传的模板制作文件（generator_make_template）
        //todo 1h33min
        cosManager.deleteDir("5a3b5249f1008bc6f9c2130749c9d6d8.jpg/");

        // 2. 已删除的代码生成器对应的产物包文件（generator_dist）。
        List<Generator> generatorList = generatorMapper.listDeletedGenerator();
        List<String> keyList = generatorList.stream().map(Generator::getDistPath)
                .filter(StrUtil::isNotBlank)
                // 移除 '/' 前缀
                .map(distPath -> distPath.substring(1))
                .collect(Collectors.toList());

        cosManager.deleteObjects(keyList);
        log.info("clearCosJobHandler end");
    }

}
