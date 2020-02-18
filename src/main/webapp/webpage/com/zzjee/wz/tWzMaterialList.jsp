<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tWzMaterialList" checkbox="true" pagination="true" fitColumns="true" title="物资" actionUrl="tWzMaterialController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
     <t:dgCol title="物资编码"  field="matCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="物资名称"  field="matName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="matUnit"  queryMode="single"  dictionary="ba_unit,UNIT_CODE,UNIT_ZH_NAME"  width="120"></t:dgCol>
   <t:dgCol title="规格"  field="matGuige"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="等级"  field="matClass"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="标准价元"  field="matPrice"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="安全库存"  field="matAqkc"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="仓库"  field="matLocation"  queryMode="single"  dictionary="t_wz_location,mat_location,mat_location"  width="120"></t:dgCol>
   <t:dgCol title="备用1"  field="by1"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用2"  field="by2"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用3"  field="by3"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用4"  field="by4"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用5"  field="by5"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tWzMaterialController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tWzMaterialController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tWzMaterialController.do?goUpdate" funname="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tWzMaterialController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tWzMaterialController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/zzjee/wz/tWzMaterialList.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tWzMaterialController.do?upload', "tWzMaterialList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tWzMaterialController.do?exportXls","tWzMaterialList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tWzMaterialController.do?exportXlsByT","tWzMaterialList");
}

 </script>