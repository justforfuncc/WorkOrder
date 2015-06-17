package io.rollenholt.github.workorder.pojo.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * rollenholt
 * 2015/6/17.
 */
public class WorkOrderProperties {

    private Integer workOrderId;

    private String key;

    private String value;

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
