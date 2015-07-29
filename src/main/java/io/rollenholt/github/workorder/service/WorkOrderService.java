package io.rollenholt.github.workorder.service;

import com.google.common.collect.Lists;
import io.rollenholt.github.workorder.component.HbaseComponent;
import io.rollenholt.github.workorder.pojo.vo.WorkOrderVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * rollenholt
 * 2015/6/17.
 */
@Service
public class WorkOrderService {

    @Resource
    private HbaseComponent hbaseComponent;

    public int create(WorkOrderVo workOrderVo) {
        return 0;
    }

    public WorkOrderVo queryWorkOderById(int workOrderId) {
        WorkOrderVo workOrderVo = new WorkOrderVo();
        workOrderVo.setId(1);
        workOrderVo.setName("xxx");
        workOrderVo.setPriority(2);
        workOrderVo.setDetail("xxxx");
        return workOrderVo;
    }

    public List<WorkOrderVo> queryAllData(Integer limit, Integer offset) {
        WorkOrderVo workOrderVo = new WorkOrderVo();
        workOrderVo.setId(1);
        workOrderVo.setName("xxx");
        workOrderVo.setPriority(1);
        workOrderVo.setDetail("xxxx");
        return Lists.newArrayList(workOrderVo);
    }
}
