package io.rollenholt.github.workorder.controller;

import com.rollenholt.pear.pojo.JsonV2;
import io.rollenholt.github.workorder.pojo.vo.WorkOrderVo;
import io.rollenholt.github.workorder.service.WorkOrderService;
import io.rollenholt.github.workorder.validation.WorkOrderVoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new WorkOrderVoValidator());
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView toCreatePage(){
        return new ModelAndView("workOrderCreate");
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView queryAll(@RequestParam(value = "limit", required = false) Integer limit,
                                 @RequestParam(value = "offset", required = false) Integer offset){
        return new ModelAndView("workOrderList");
    }


}
