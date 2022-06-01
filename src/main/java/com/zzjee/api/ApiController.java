package com.zzjee.api;

import com.zzjee.md.controller.MdGoodsController;
import com.zzjee.md.entity.MdCusEntity;
import com.zzjee.md.entity.MdGoodsEntity;
import com.zzjee.md.entity.MvGoodsEntity;
import com.zzjee.wave.controller.WaveToDownController;
import com.zzjee.wave.controller.WaveToFjController;
import com.zzjee.wm.controller.*;
import com.zzjee.wm.entity.WmImNoticeHEntity;
import com.zzjee.wm.entity.WmImNoticeIEntity;
import com.zzjee.wm.entity.WmInQmIEntity;
import com.zzjee.wmapi.controller.WvGiController;
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
    @Autowired
    private WvGiController wvGiController;
    @Autowired
    private WaveToDownController waveToDownController;
    @Autowired
    private WaveToFjController waveToFjController;
    @Autowired
    private WvStockController wvStockController;
    @Autowired
    private WmToMoveGoodsController wmToMoveGoodsController;
    @Autowired
    private WmSttInGoodsController wmSttInGoodsController;
    @Autowired
    private MdGoodsController mdGoodsController;
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
     @RequestMapping(value = "/wvGiController/list",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list4(@RequestParam(value = "username", required = false) String username,
                                  @RequestParam(value = "searchstr", required = false) String searchstr,
                                  @RequestParam(value = "searchstr2", required = false) String searchstr2) {
        return wvGiController.list(username,searchstr,searchstr2);
    }
    //装车复核保存
    @RequestMapping(value = "/wmToDownGoodsController/change", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  ResponseEntity<?> update4(@RequestParam String wmToDownGoodsstr,
                                     UriComponentsBuilder uriBuilder) {
        return wmToDownGoodsController.update(wmToDownGoodsstr,uriBuilder);
    }

    //波次下架列表
    @RequestMapping(value = "/waveToDownController/list/todown",  method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list5(@RequestParam(value="username", required=false) String username,
                                  @RequestParam(value="searchstr", required=false)String searchstr,
                                  @RequestParam(value="searchstr2", required=false)String searchstr2,
                                  @RequestParam(value="searchstr3", required=false)String searchstr3) {
     return    waveToDownController.list(username,searchstr,searchstr2,searchstr3);
    }
    //波次下架保存
    @RequestMapping(value = "/waveToDownController/save",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create5(@RequestParam String waveToDownstr ,UriComponentsBuilder uriBuilder) {
        return waveToDownController.create(waveToDownstr,uriBuilder);
    }

    //波次分拣列表

    @RequestMapping(value = "/waveToFjController/list/tofj",  method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list(@RequestParam(value="username", required=false) String username,
                                  @RequestParam(value="searchstr", required=false)String searchstr,
                                  @RequestParam(value="searchstr2", required=false)String searchstr2,
                                  @RequestParam(value="searchstr3", required=false)String searchstr3,
                                  @RequestParam(value="searchstr4", required=false)String searchstr4,//二次容器
                                  @RequestParam(value="searchstr5", required=false)String searchstr5){
        return waveToFjController.list(username,searchstr,searchstr2,searchstr3,searchstr4,searchstr5);
    }
    //波次分拣保存
    @RequestMapping(value = "/waveToFjController/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create(@RequestParam String waveToFjstr , UriComponentsBuilder uriBuilder) {
        return waveToFjController.create(waveToFjstr,uriBuilder);
    }
    //库存列表
    @RequestMapping(value = "/wvStockController/list",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list(@RequestParam(value = "username", required = false) String username,
                                  @RequestParam(value = "searchstr", required = false) String searchstr,
                                  @RequestParam(value = "searchstr2", required = false) String searchstr2) {
        return wvStockController.list(username,searchstr,searchstr2);
    }
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
