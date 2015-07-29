package io.rollenholt.github.workorder.pojo.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * rollenholt
 * 2015/6/17.
 */
public class WorkOrderVo {

    private int id;

    private String name;

    private int priority;

    private String detail;

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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
