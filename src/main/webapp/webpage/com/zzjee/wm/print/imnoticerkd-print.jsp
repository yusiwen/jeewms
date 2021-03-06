<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>入库单打印</title>
	<t:base type="jquery,easyui,tools"></t:base>
	<script type="text/javascript" charset="utf-8" src="webpage/com/zzjee/wmjs/jquery.jqprint.js"></script>
	<script language="javascript">
		function printall(){

			$(".printdiv").jqprint();

		}
		function printview(){
			document.all.WebBrowser1.ExecWB(7,1);
		}


	</script>
	<style>
		tr
		{mso-height-source:auto;
			mso-ruby-visibility:none;}
		col
		{mso-width-source:auto;
			mso-ruby-visibility:none;}
		br
		{mso-data-placement:same-cell;}
		ruby
		{ruby-align:left;}
		.style0
		{mso-number-format:General;
			text-align:general;
			vertical-align:bottom;
			white-space:nowrap;
			mso-rotate:0;
			mso-background-source:auto;
			mso-pattern:auto;
			color:windowtext;
			font-size:14pt;
			font-weight:400;
			font-style:normal;
			text-decoration:none;
			font-family: 黑体;
			mso-font-charset:0;
			border:none;
			mso-protection:locked visible;
			mso-style-name:常规;
			mso-style-id:0;}
		td
		{mso-style-parent:style0;
			padding-top:1px;
			padding-right:1px;
			padding-left:1px;
			mso-ignore:padding;
			color:windowtext;
			font-size:14pt;
			font-weight:400;
			font-style:normal;
			text-decoration:none;
			font-family:黑体;
			mso-font-charset:0;
			mso-number-format:General;
			text-align:general;
			vertical-align:bottom;
			border:none;
			mso-background-source:auto;
			mso-pattern:auto;
			mso-protection:locked visible;
			white-space:nowrap;
			mso-rotate:0;}
		.xl65
		{mso-style-parent:style0;
			color:black;
			font-size:16pt;
			text-align:center;
			border:1.0pt solid black;}
		.xl66
		{mso-style-parent:style0;
			color:black;
			font-size:16pt;}
		.xl67
		{mso-style-parent:style0;
			color:black;
			font-size:18pt;
			text-align:center;}
		.xl68
		{mso-style-parent:style0;
			color:black;
			font-size:16pt;
			white-space:normal;}
		.xl69
		{mso-style-parent:style0;
			text-align:center;}

	</style>

</head>
<body style="overflow-y:auto" scroll="no">
<a class="easyui-linkbutton" style="margin-top:3px" icon="icon-print" href="javascript:printall()">打印</a>

<div class="printdiv"><t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table"  >
	<input id="content" type="hidden" value="${printHeader.header05}">
	<table border=0 cellpadding=0 cellspacing=0 width=680 style='border-collapse:
 collapse;table-layout:fixed;width:438pt;margin-left: 30px;margin-top: -30px'>
		<col width=45 style='mso-width-source:userset;mso-width-alt:3612;width:45pt'>

			<%--<col width=84 style='mso-width-source:userset;mso-width-alt:2986;width:63pt'>--%>
		<col width=100 style='mso-width-source:userset;mso-width-alt:4010;width:100pt'>
		<col width=145 style='mso-width-source:userset;mso-width-alt:1592;width:134pt'>
		<col width=100  style='mso-width-source:userset;mso-width-alt:2986;
 width:80pt'>
		<col width=67 style='mso-width-source:userset;mso-width-alt:2389;width:50pt'>
		<col width=102 style='mso-width-source:userset;mso-width-alt:2389;width:60pt'>
		<col width=67 style='mso-width-source:userset;mso-width-alt:2389;width:50pt'>
		<col width=67 style='mso-width-source:userset;mso-width-alt:2389;width:50pt'>
		<col width=67 style='mso-width-source:userset;mso-width-alt:2389;width:50pt'>


		<tr height=18 style='height:13.2pt'>
			<td colspan=9 height=18 width=585 style='height:13.2pt;width:438pt'></td>
		</tr>
		<tr height=18 style='height:13.2pt'>
			<td colspan=2 style='mso-ignore:colspan'></td>

			<td colspan=7 height=18 width=585 style='height:13.2pt;width:438pt'><span style="font-size: 18pt">${printHeader.header01}</span></td>
		</tr>
		<tr height=40 style='mso-height-source:userset;height:30.0pt'>
			<td colspan=9 class=xl68 width=168 style='width:126pt'>${printHeader.header02}</td>
<%--			<td  rowspan="3" class=xl69>--%>
<%--				<img src="rest/wmBaseController/showOrDownqrcodeByurl?qrvalue=${wmImNoticeHPage.noticeId}" style="width:80px;height:80px;vertical-align:right">--%>
<%--			</td>--%>
		</tr>
		<tr height=40 style='mso-height-source:userset;height:30.0pt'>
			<td colspan=4 height=40 class=xl67 style='height:30.0pt'>${printHeader.header04}</td>
			<td colspan=3 class=xl68 width=168 style='width:126pt'>${printHeader.header05}</td>
			<td colspan=2 style='mso-ignore:colspan'></td>
		</tr>
		<tr height=40 style='mso-height-source:userset;height:30.0pt'>
			<td colspan=4 height=40 class=xl68 width=242 style='height:30.0pt;width:182pt'>${printHeader.header08}</td>
			<td colspan=3 height=40 class=xl68 width=242 style='height:30.0pt;width:182pt'>${printHeader.header09}</td>
			<td></td>
		</tr>
		<tr height=40 style='mso-height-source:userset;height:30.0pt'>
			<td colspan=4 class=xl68 width=337 style='width:252pt'>${printHeader.header14}</td>
			<td colspan=3 >${printHeader.header06}</td>
			<td></td>
		</tr>


		<tr height=33 style='mso-height-source:userset;height:25.05pt'>
			<td class=xl65 style='border:1.0pt solid black;text-align: center'>序号</td>

			<td class=xl65 style='border:1.0pt solid black;text-align: center'>商品编码</td>
				<%--<td class=xl65 style='border:1.0pt solid black;text-align: center'>商品编码</td>--%>
			<td height=33 class=xl65 style='height:25.05pt;border:1.0pt solid black;text-align: center'>商品</td>
			<td class=xl65 style='border:1.0pt solid black;text-align: center'>生产日期</td>

			<td class=xl65 style='border:1.0pt solid black;text-align: center'>收货温度</td>
			<td class=xl65 style='border:1.0pt solid black;text-align: center'>单位</td>
			<td class=xl65 style='border:1.0pt solid black;text-align: center'>数量</td>

			<td class=xl65 style='border:1.0pt solid black;text-align: center'>重量</td>
			<td class=xl65 style='border:1.0pt solid black;text-align: center'>容积</td>



			<td  ></td>
		</tr>

		<c:if test="${fn:length(listitem)  > 0 }">
			<c:forEach items="${listitem}" var="poVal" varStatus="stuts">

				<tr height=33 style='mso-height-source:userset;height:50px'>
					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item20 }　</td>
						<%--<td height=33 class=xl65 style='height:25.05pt;border:1.0pt solid black;text-align: center'>${poVal.goodsCode }</td>--%>
					<td class=xl65 style='border:1.0pt solid black;text-align: center;word-break:break-all;'><span style='word-break:break-all;width: auto;font-size: 14pt'>${poVal.item01 }</span></td>
					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item02 }</td>

					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item03 }</td>
					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item04 }</td>
					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item05 }</td>

					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item06 }</td>
					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item07 }</td>

					<td class=xl65 style='border:1.0pt solid black;text-align: center'>${poVal.item08 }</td>


					<td  ></td>
				</tr>

			</c:forEach>
		</c:if>
		<tr height=20 style='height:25.0pt'>
			<td height=20 class=xl66 colspan=8 style='height:15.0pt;mso-ignore:colspan;text-align: justify'>制单人：<span
					style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span>合计重量： ${printHeader.header13}<span
					style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span>合计数量:${printHeader.header12}<span
					style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span>客户签字（盖章）<span
			<td></td>
		</tr>

	</table>
</t:formvalid></div>
</body>
