<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>打印模板</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wmPrintModelController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${wmPrintModelPage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${wmPrintModelPage.createName }"/>
		<input id="createBy" name="createBy" type="hidden" value="${wmPrintModelPage.createBy }"/>
		<input id="createDate" name="createDate" type="hidden" value="${wmPrintModelPage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${wmPrintModelPage.updateName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${wmPrintModelPage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${wmPrintModelPage.updateDate }"/>
		<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wmPrintModelPage.sysOrgCode }"/>
		<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wmPrintModelPage.sysCompanyCode }"/>
		<input id="query1" name="query1" type="hidden" value="${wmPrintModelPage.query1 }"/>
		<input id="query2" name="query2" type="hidden" value="${wmPrintModelPage.query2 }"/>
		<input id="query3" name="query3" type="hidden" value="${wmPrintModelPage.query3 }"/>
		<input id="query4" name="query4" type="hidden" value="${wmPrintModelPage.query4 }"/>
		<input id="query5" name="query5" type="hidden" value="${wmPrintModelPage.query5 }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名:
						</label>
					</td>
					<td class="value">
					     	 <input id="userName" name="userName" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							打印类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="printType" type="list"
									typeGroupCode="print_type" defaultVal="${wmPrintModelPage.printType}" hasLabel="false"  title="打印类型"  
									></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">打印类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							打印模板:
						</label>
					</td>
					<td class="value">
					     	 <input id="printModel" name="printModel" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">打印模板</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							打印服务器地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="printServerAddress" name="printServerAddress" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">打印服务器地址</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							打印文件类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="printFileType" name="printFileType" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">打印文件类型</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/zzjee/wm/wmPrintModel.js"></script>		
