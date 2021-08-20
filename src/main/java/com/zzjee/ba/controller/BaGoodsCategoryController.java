package com.zzjee.ba.controller;
import com.zzjee.ba.entity.BaGoodsCategoryEntity;
import com.zzjee.ba.service.BaGoodsCategoryServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzjee.ba.vo.BaGoodsCategoryVo;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @Title: Controller
 * @Description: 商品类目
 * @author onlineGenerator
 * @date 2021-08-20 10:29:34
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/baGoodsCategoryController")
public class BaGoodsCategoryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaGoodsCategoryController.class);

	@Autowired
	private BaGoodsCategoryServiceI baGoodsCategoryService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CommonService commonService;



	/**
	 * 商品类目列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/zzjee/ba/baGoodsCategoryList");
	}

	/**
	 * easyui AJAX请求数据
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BaGoodsCategoryEntity baGoodsCategory,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BaGoodsCategoryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baGoodsCategory, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_createTime_begin = request.getParameter("createTime_begin");
		String query_createTime_end = request.getParameter("createTime_end");
		if(StringUtil.isNotEmpty(query_createTime_begin)){
			cq.ge("createTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_createTime_begin));
		}
		if(StringUtil.isNotEmpty(query_createTime_end)){
			cq.le("createTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_createTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.baGoodsCategoryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除商品类目
	 *
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BaGoodsCategoryEntity baGoodsCategory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		baGoodsCategory = systemService.getEntity(BaGoodsCategoryEntity.class, baGoodsCategory.getId());
		message = "商品类目删除成功";
		try{
			baGoodsCategoryService.delete(baGoodsCategory);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "商品类目删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除商品类目
	 *
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商品类目删除成功";
		try{
			for(String id:ids.split(",")){
				BaGoodsCategoryEntity baGoodsCategory = systemService.getEntity(BaGoodsCategoryEntity.class,
				Integer.parseInt(id)
				);
				baGoodsCategoryService.delete(baGoodsCategory);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "商品类目删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加商品类目
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BaGoodsCategoryEntity baGoodsCategory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商品类目添加成功";
		try{
			baGoodsCategoryService.save(baGoodsCategory);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "商品类目添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新商品类目
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BaGoodsCategoryEntity baGoodsCategory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商品类目更新成功";
		BaGoodsCategoryEntity t = baGoodsCategoryService.get(BaGoodsCategoryEntity.class, baGoodsCategory.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(baGoodsCategory, t);
			baGoodsCategoryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "商品类目更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 商品类目新增页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BaGoodsCategoryEntity baGoodsCategory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baGoodsCategory.getId())) {
			baGoodsCategory = baGoodsCategoryService.getEntity(BaGoodsCategoryEntity.class, baGoodsCategory.getId());
			req.setAttribute("baGoodsCategoryPage", baGoodsCategory);
		}
		return new ModelAndView("com/zzjee/ba/baGoodsCategory-add");
	}
	/**
	 * 商品类目编辑页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BaGoodsCategoryEntity baGoodsCategory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baGoodsCategory.getId())) {
			baGoodsCategory = baGoodsCategoryService.getEntity(BaGoodsCategoryEntity.class, baGoodsCategory.getId());
			req.setAttribute("baGoodsCategoryPage", baGoodsCategory);
		}
		return new ModelAndView("com/zzjee/ba/baGoodsCategory-update");
	}

	/**
	 * 导入功能跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","baGoodsCategoryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BaGoodsCategoryEntity baGoodsCategory,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BaGoodsCategoryEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baGoodsCategory, request.getParameterMap());
		List<BaGoodsCategoryEntity> baGoodsCategorys = this.baGoodsCategoryService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"商品类目");
		modelMap.put(NormalExcelConstants.CLASS,BaGoodsCategoryEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("商品类目列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,baGoodsCategorys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BaGoodsCategoryEntity baGoodsCategory,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"商品类目");
    	modelMap.put(NormalExcelConstants.CLASS,BaGoodsCategoryEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("商品类目列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<BaGoodsCategoryEntity> listBaGoodsCategoryEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BaGoodsCategoryEntity.class,params);
				for (BaGoodsCategoryEntity baGoodsCategory : listBaGoodsCategoryEntitys) {
					baGoodsCategoryService.save(baGoodsCategory);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<BaGoodsCategoryEntity> list() {
		List<BaGoodsCategoryEntity> listBaGoodsCategorys=baGoodsCategoryService.getList(BaGoodsCategoryEntity.class);
		return listBaGoodsCategorys;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		BaGoodsCategoryEntity task = baGoodsCategoryService.get(BaGoodsCategoryEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody BaGoodsCategoryEntity baGoodsCategory, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaGoodsCategoryEntity>> failures = validator.validate(baGoodsCategory);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			baGoodsCategoryService.save(baGoodsCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		int id = baGoodsCategory.getId();
		URI uri = uriBuilder.path("/rest/baGoodsCategoryController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody BaGoodsCategoryEntity baGoodsCategory) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaGoodsCategoryEntity>> failures = validator.validate(baGoodsCategory);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			baGoodsCategoryService.saveOrUpdate(baGoodsCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		baGoodsCategoryService.deleteEntityById(BaGoodsCategoryEntity.class, id);
	}

	@RequestMapping(params = "getGoodsTreeList")
	@ResponseBody
	public AjaxJson getGoodsTreeList(){

		List<BaGoodsCategoryVo> treeList = new ArrayList<>();
		List<BaGoodsCategoryEntity> dataList = systemService.findHql("from BaGoodsCategoryEntity order by id");

		for (BaGoodsCategoryEntity baGoodsCategoryEntity : dataList) {

			BaGoodsCategoryVo baGoodsCategoryVo = new BaGoodsCategoryVo();
			baGoodsCategoryVo.setLabel(baGoodsCategoryEntity.getCategoryName());
			baGoodsCategoryVo.setValue(baGoodsCategoryEntity.getId());
			baGoodsCategoryVo.setPid(baGoodsCategoryEntity.getPid());
			if (baGoodsCategoryVo.getPid() == null){
				System.out.println();
			}
			if (baGoodsCategoryVo.getPid() == 0) {
				treeList.add(baGoodsCategoryVo);
			}else {
				BaGoodsCategoryVo parent = findParent(treeList,baGoodsCategoryVo.getPid());
				if(parent!=null){
					if(parent.getChildren()==null){
						parent.setChildren(new ArrayList<>());
					}
					parent.getChildren().add(baGoodsCategoryVo);
				} else {
					treeList.add(baGoodsCategoryVo);
				}
			}
		}
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.setSuccess(true);
		ajaxJson.setMsg("查询成功");
		ajaxJson.setObj(treeList);


		return ajaxJson;

	}

	private BaGoodsCategoryVo findParent(List<BaGoodsCategoryVo> treeList, Integer pid) {
		BaGoodsCategoryVo find = null;
		for(BaGoodsCategoryVo baGoodsCategoryVo:treeList){
			if(baGoodsCategoryVo.getValue().equals(pid)){
				find = baGoodsCategoryVo;
				break;
			} else if(baGoodsCategoryVo.getChildren()!=null) {
				find = findParent(baGoodsCategoryVo.getChildren(),pid);
				if(find!=null){
					break;
				}
			}
		}
		return find;
	}


}
