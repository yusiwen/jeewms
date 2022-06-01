package com.zzjee.api;

import com.zzjee.md.entity.MdCusEntity;
import com.zzjee.md.entity.MdGoodsEntity;
import com.zzjee.md.entity.MvGoodsEntity;
import com.zzjee.wm.controller.WmInQmIController;
import com.zzjee.wm.controller.WmToDownGoodsController;
import com.zzjee.wm.controller.WmToUpGoodsController;
import com.zzjee.wm.entity.WmImNoticeHEntity;
import com.zzjee.wm.entity.WmImNoticeIEntity;
import com.zzjee.wm.entity.WmInQmIEntity;
import com.zzjee.wmapi.controller.WvGiNoticeController;
import com.zzjee.wmapi.controller.WvNoticeController;
import com.zzjee.wmapi.entity.WvNoticeEntity;
import com.zzjee.wmutil.wmUtil;
import io.swagger.models.HttpMethod;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSBaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Package com.zzjee.api
 * @date 2021/7/22 10:47
 * @description
 */
@RestController
@RequestMapping("/pdaapi")
public class ApiController {
    @Autowired
    private WvNoticeController wvNoticeController;
    @Autowired
    private WmInQmIController wmInQmIController;
    @Autowired
    private WmToUpGoodsController wmToUpGoodsController;
    @Autowired
    private WvGiNoticeController wvGiNoticeController;
    @Autowired
    private WmToDownGoodsController wmToDownGoodsController;
    //收货相关接口begin
    //收货列表
    @RequestMapping(value = "/wvNoticeController/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list1(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "searchstr", required = false) String searchstr,
                                   @RequestParam(value = "searchstr2", required = false) String searchstr2) {
        return wvNoticeController.list(username, searchstr, searchstr2);
    }

    //收货保存
    @RequestMapping(value = "/wmInQmIController/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create1(@RequestParam String wmInQmIstr,
                                    UriComponentsBuilder uriBuilder) {
        return wmInQmIController.create(wmInQmIstr, uriBuilder);
    }
    //收货相关接口end

    //上架相关接口begin
    //上架列表
    @RequestMapping(value = "/wmInQmIController/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list2(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "searchstr", required = false) String searchstr,
                                   @RequestParam(value = "searchstr2", required = false) String searchstr2) {
        return wmInQmIController.list(username, searchstr, searchstr2);
    }
    //保存上架
    @RequestMapping(value = "/wmToUpGoodsController/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create2(@RequestParam String wmToUpGoodsstr, UriComponentsBuilder uriBuilder) {
        return wmToUpGoodsController.create(wmToUpGoodsstr,uriBuilder);
    }
    //上架相关接口end

    //下架相关接口begin
    //按单拣货列表
    //下架任务  PDA接口
    @RequestMapping(value = "/wvGiNoticeController/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list3(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "searchstr", required = false) String searchstr,
                                   @RequestParam(value = "searchstr2", required = false) String searchstr2,
                                   @RequestParam(value = "searchstr3", required = false) String searchstr3) {
        return wvGiNoticeController.lists(username,searchstr,searchstr2,searchstr3);
    }
    //保存下架
    //下架
    @RequestMapping(value = "/wmToDownGoodsController/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public synchronized ResponseEntity<?> create3(@RequestParam String wmToDownGoodsstr,
                                                 UriComponentsBuilder uriBuilder) {
        return wmToDownGoodsController.create(wmToDownGoodsstr,uriBuilder);
    }
    //下架相关接口end

    //装车复核列表
    public static final String wvGiController = "/rest/wvGiController";
    //装车复核保存
    public static final String wmToDownGoodsControllerc = "/rest/wmToDownGoodsController/change";


    //波次下架列表
    public static final String waveToDownList = "/rest/waveToDownController/list/todown";
    //波次下架保存
    public static final String waveToDownSave = "/rest/waveToDownController";

    //波次分拣列表
    public static final String waveToFjList = "/rest/waveToFjController/list/tofj";
    //波次分拣保存
    public static final String waveToFjSave = "/rest/waveToFjController";

    //库存列表
    public static final String StockController = "/rest/wvStockController";

    //移储列表
    public static final String ToMoveGoodsController = "/rest/wmToMoveGoodsController";
    //移储保存
    public static final String wmToMoveGoodsControllerc = "/rest/wmToMoveGoodsController/change";

    //盘点列表
    public static final String SttInGoodsController = "/rest/wmSttInGoodsController";
    //盘点保存
    public static final String wmSttInGoodsControllerc = "/rest/wmSttInGoodsController/change";

    //商品列表
    public static final String GoodsController = "/rest/mdGoodsController";
    //商品信息保存
    public static final String mdGoodsControllerc = "/rest/mdGoodsController/change";
    //商品下单
    public static final String mdGoodsControllercorder = "/rest/mdGoodsController/order";

}
