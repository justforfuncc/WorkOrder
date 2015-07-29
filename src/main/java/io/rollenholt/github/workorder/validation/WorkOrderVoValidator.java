package io.rollenholt.github.workorder.validation;

import com.google.common.base.Strings;
import io.rollenholt.github.workorder.pojo.vo.WorkOrderVo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * rollenholt
 * 2015/7/9.
 */
public class WorkOrderVoValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return aClass.equals(WorkOrderVo.class);
    }

    public void validate(Object o, Errors errors) {
        WorkOrderVo workOrderVo = (WorkOrderVo) o;
        String name = workOrderVo.getName();
        if(Strings.isNullOrEmpty(name) || name.length() > 100){
            errors.reject("workorder name must not be empty or null and length is less than 100");
        }
    }
}
