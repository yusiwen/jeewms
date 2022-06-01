package com.zzjee.api;

import io.swagger.models.HttpMethod;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.zzjee.api
 * @date 2021/7/22 10:47
 * @description
 */
@RestController
@RequestMapping("/pdaapi")
public class ApiController {


    @RequestMapping(value = "/getToken",method = RequestMethod.GET)
    @ResponseBody
    public AjaxJson test(){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setSuccess(true);
        ajaxJson.setMsg("操作成功");
        return ajaxJson;
    }
}
