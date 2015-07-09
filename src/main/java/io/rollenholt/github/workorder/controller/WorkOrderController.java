package io.rollenholt.github.workorder.controller;

import com.rollenholt.pear.pojo.JsonV2;
import io.rollenholt.github.workorder.pojo.vo.WorkOrderVo;
import io.rollenholt.github.workorder.service.WorkOrderService;
import io.rollenholt.github.workorder.validation.WorkOrderVoValidator;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * rollenholt
 * 2015/6/17.
 */
@Controller
@RequestMapping(value = "workorder")
public class WorkOrderController {

    @Resource
    private WorkOrderService workOrderService;


    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new WorkOrderVoValidator());
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonV2 create(@RequestBody @Validated WorkOrderVo workOrderVo, BindingResult validateResult){

        return new JsonV2<String>(0, "ok", null);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public JsonV2 modify(@RequestBody @Validated WorkOrderVo workOrderVo, BindingResult validateResult){

        return new JsonV2<String>(0, "ok", null);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public JsonV2 queryAll(@RequestParam("limit") int limit,
                           @RequestParam("offset") int offset){
        RowBounds rowBounds = new RowBounds(limit, offset);

        return new JsonV2<String>(0, "ok", null);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        System.out.println("asdsad");
        return "workOrder";
    }

}
