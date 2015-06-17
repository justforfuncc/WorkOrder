package io.rollenholt.github.workorder.controller;

import com.rollenholt.pear.pojo.JsonV2;
import io.rollenholt.github.workorder.pojo.vo.WorkOrderVo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * rollenholt
 * 2015/6/17.
 */
@Controller
@RequestMapping(value = "workorder")
@EnableAutoConfiguration
public class WorkOrderController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonV2 create(@RequestBody WorkOrderVo workOrderVo){

        return new JsonV2<String>(0, "ok", null);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public JsonV2 modify(@RequestBody WorkOrderVo workOrderVo){

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
    @ResponseBody
    public JsonV2 test(){
        return new JsonV2<String>(0, "ok", null);
    }


}
