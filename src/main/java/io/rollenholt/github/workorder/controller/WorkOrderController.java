package io.rollenholt.github.workorder.controller;

import com.rollenholt.pear.pojo.JsonV2;
import io.rollenholt.github.workorder.pojo.vo.WorkOrderVo;
import io.rollenholt.github.workorder.service.WorkOrderService;
import io.rollenholt.github.workorder.validation.WorkOrderVoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(WorkOrderController.class);

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new WorkOrderVoValidator());
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView toCreatePage(){
        return new ModelAndView("workOrderCreateAndModify");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Validated WorkOrderVo workOrderVo, BindingResult validateResult){
        logger.info("receive create workorder request, parameter is :{}", workOrderVo);

        return new ModelAndView("workOrderList");
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public ModelAndView toModifyPage(){
        return new ModelAndView("workOrderCreateAndModify");
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ModelAndView modify(@Validated WorkOrderVo workOrderVo, BindingResult validateResult){
        logger.info("receive modify workorder request, parameter is :{}", workOrderVo);

        return new ModelAndView("workOrderList");
    }

    @RequestMapping(value = "/detail/{workOrderId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonV2 queryWorkOderDetailById(@PathVariable("workOrderId") int workOrderId){
        WorkOrderVo workOrderVo = new WorkOrderVo();
        workOrderVo.setId(1);
        workOrderVo.setName("xxx");
        workOrderVo.setPriority(2);
        workOrderVo.setDetail("xxxx");
        return new JsonV2<Object>(0, "ok", workOrderVo);
    }

    @RequestMapping(value = "/preview/{workOrderId}", method = RequestMethod.GET)
    public ModelAndView preview(@PathVariable("workOrderId") int workOrderId) {
        return new ModelAndView("workOrderPreview");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView toListPage(@RequestParam(value = "limit", required = false) Integer limit,
                                 @RequestParam(value = "offset", required = false) Integer offset){
        return new ModelAndView("workOrderList");
    }

    @RequestMapping(value = "/list/data", method = RequestMethod.GET)
    @ResponseBody
    public JsonV2 queryAllData(@RequestParam(value = "limit", required = false) Integer limit,
                                 @RequestParam(value = "offset", required = false) Integer offset){
        WorkOrderVo workOrderVo = new WorkOrderVo();
        workOrderVo.setId(1);
        workOrderVo.setName("xxx");
        workOrderVo.setPriority(1);
        workOrderVo.setDetail("xxxx");
        return new JsonV2<Object>(0, "ok", workOrderVo);
    }

}
