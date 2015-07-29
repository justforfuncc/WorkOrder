package io.rollenholt.github.workorder.controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.rollenholt.pear.pojo.JsonV2;
import io.rollenholt.github.workorder.pojo.vo.WorkOrderVo;
import io.rollenholt.github.workorder.service.WorkOrderService;
import io.rollenholt.github.workorder.validation.WorkOrderVoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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
        return new ModelAndView("workOrderCreate");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonV2 create(@Validated WorkOrderVo workOrderVo, BindingResult validateResult){
        logger.info("receive create workorder request, parameter is :{}", workOrderVo);
        if(validateResult.hasErrors()){
            List<String> errors = Lists.transform(validateResult.getAllErrors(), new Function<ObjectError, String>() {
                @Override
                public String apply(ObjectError input) {
                    return input.getCode();
                }
            });
            return new JsonV2<List<String>>(-1, "input validate error", errors);
        }
        int workorderId = workOrderService.create(workOrderVo);
        return new JsonV2<Integer>(0, "create success", workorderId);
    }

    @RequestMapping(value = "/detail/{workOrderId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonV2 queryWorkOderDetailById(@PathVariable("workOrderId") int workOrderId){
        WorkOrderVo workOrderVo = workOrderService.queryWorkOderById(workOrderId);
        return new JsonV2<Object>(0, "ok", workOrderVo);
    }

    @RequestMapping(value = "/preview/{workOrderId}", method = RequestMethod.GET)
    public ModelAndView preview(@PathVariable("workOrderId") int workOrderId) {
        return new ModelAndView("workOrderPreview");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView toListPage(){
        return new ModelAndView("workOrderList");
    }

    @RequestMapping(value = "/list/data", method = RequestMethod.GET)
    @ResponseBody
    public JsonV2 queryAllData(@RequestParam(value = "limit", required = false) Integer limit,
                                 @RequestParam(value = "offset", required = false) Integer offset){
        List<WorkOrderVo> workOrderVos = workOrderService.queryAllData(limit, offset);
        return new JsonV2<Object>(0, "ok", workOrderVos);
    }

}
