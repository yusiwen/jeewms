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
    //收货相关接口begin
    //收货列表
    public static final String NoticeController = "/rest/pdaapi/wvNoticeController";
    //收货保存
    public static final String wmInQmIController = "/rest/pdaapi/wmInQmIController";
    //收货相关接口end

    //上架相关接口begin
    //上架列表
    public static final String InQmIController = "/rest/pdaapi/wmInQmIController";
    //保存上架
    public static final String wmToUpGoodsController = "/rest/pdaapi/wmToUpGoodsController";
    //上架相关接口end

    //下架相关接口begin
    //按单拣货列表
    public static final String GINOTICE = "/rest/pdaapi/wvGiNoticeController";
    //保存下架
    public static final String SAVEGINOTICE = "/rest/pdaapi/wmToDownGoodsController";
    //下架相关接口end

    //盘点列表
    public static final String SttInGoodsController = "/rest/pdaapi/wmSttInGoodsController";
    //盘点保存
    public static final String wmSttInGoodsControllerc = "/rest/pdaapi/wmSttInGoodsController/change";

    //移储列表
    public static final String ToMoveGoodsController = "/rest/pdaapi/wmToMoveGoodsController";
    //移储保存
    public static final String wmToMoveGoodsControllerc = "/rest/pdaapi/wmToMoveGoodsController/change";

    //库存列表
    public static final String StockController = "/rest/pdaapi/wvStockController";

    //装车复核列表
    public static final String wvGiController = "/rest/pdaapi/wvGiController";
    //装车复核保存
    public static final String wmToDownGoodsControllerc = "/rest/pdaapi/wmToDownGoodsController/change";

    //商品列表
    public static final String GoodsController = "/rest/pdaapi/mdGoodsController";
    //商品信息保存
    public static final String mdGoodsControllerc = "/rest/pdaapi/mdGoodsController/change";
    //商品下单
    public static final String mdGoodsControllercorder = "/rest/pdaapi/mdGoodsController/order";

    //波次下架列表
    public static final String waveToDownList = "/rest/pdaapi/waveToDownController/list/todown";
    //波次下架保存
    public static final String waveToDownSave = "/rest/pdaapi/waveToDownController";

    //波次分拣列表
    public static final String waveToFjList = "/rest/pdaapi/waveToFjController/list/tofj";
    //波次分拣保存
    public static final String waveToFjSave = "/rest/pdaapi/waveToFjController";

}
