package org.jeecg.modules.manage.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.manage.entity.LoitSeleniumBatch;
import org.jeecg.modules.manage.entity.LoitSeleniumProject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  批次配置表
 */
@Repository
public interface LoitSeleniumBatchMapper extends BaseMapper<LoitSeleniumBatch>  {
    List<LoitSeleniumBatch> getBatchList(@Param("batchName") String batchName,
                                         @Param("projectName") String projectName,
                                         @Param("batchProcessState") String batchProcessState,
                                         @Param("batchTreatmentState") String batchTreatmentState,
                                         @Param("startNum") Integer startNum,
                                         @Param("pageSize") Integer pageSize);
}

