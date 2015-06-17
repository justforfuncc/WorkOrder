package io.rollenholt.github.workorder.pojo.vo;

import io.rollenholt.github.workorder.pojo.model.WorkOrderProperties;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;
import java.util.List;

/**
 * rollenholt
 * 2015/6/17.
 */
public class WorkOrderVo {

    private int id;

    private String name;

    private Date createTime;

    private String lastUpdateTime;

    private List<WorkOrderProperties> workOrderProperties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<WorkOrderProperties> getWorkOrderProperties() {
        return workOrderProperties;
    }

    public void setWorkOrderProperties(List<WorkOrderProperties> workOrderProperties) {
        this.workOrderProperties = workOrderProperties;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
