package com.ccyx.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccyx.web.model.entity.Generator;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
* @author ccyx
* @description 针对表【generator(代码生成器)】的数据库操作Mapper
* @createDate 2024-01-16 17:36:04
* @Entity com.ccyx.web.model.entity.Generator
*/
public interface GeneratorMapper extends BaseMapper<Generator> {
    @Select("SELECT id, distPath FROM generator WHERE isDelete = 1")
    List<Generator> listDeletedGenerator();
}




