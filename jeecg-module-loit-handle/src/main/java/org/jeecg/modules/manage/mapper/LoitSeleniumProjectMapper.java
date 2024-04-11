package org.jeecg.modules.manage.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.manage.entity.LoitSeleniumProject;
import org.jeecg.modules.manage.entity.LoitSeleniumProjectDictionary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  项目配置表
 */
@Repository
public interface LoitSeleniumProjectMapper extends BaseMapper<LoitSeleniumProject>  {
    List<LoitSeleniumProjectDictionary> getProject();
    @InterceptorIgnore(tenantLine = "true")
    @Select("SELECT * FROM selenium_project where id = #{projectId}")
    LoitSeleniumProject getprojectInfo(@Param("projectId") String projectId);
}
