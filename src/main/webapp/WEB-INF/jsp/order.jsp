<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>発注画面</title>
</head>
<body>
	<h2>発注</h2>
	<hr />
	<form name="searchform" action="/sizaikanri/order/search"
		method="post">
		<table>
		<tr>
				<s:select name="form.deptid"
					list="form.deptList" listKey="id" listValue="name" />
		</tr>
		</table>
		<input type="submit" value="検索" />
	</form>
	<s:if test="form.sizaiList != null && form.sizaiList.size !=0">
		<table class="outputtable">
	<tr>
		<th>資材ID</th>
		<th>資材名</th>
		<th>数量</th>
		<th>カテゴリ</th>
		<th>購入依頼者</th>
		<th>購入依頼部門</th>
		<th>状態</th>
		<th>依頼日</th>
		<th>発注</th>


	</tr>
		<s:iterator value="form.sizaiList">
	<tr>
		<td>
			<s:property value="id"/>
		</td>
		<td>
			<a target="under" href="/sizaikanri/approvalDetail/init?form.id=<s:property value="id"/>"><s:property value="name"/></a>
		</td>
		<td>
			<s:property value="num"/>
		</td>
		<td>
			<s:property value="category_name"/>
		</td>
		<td>
			<s:property value="request_user_name"/>
		</td>
		<td>
			<s:property value="request_dept_name"/>
		</td>
		<td>
			<s:property value="status_name"/>
		</td>
		<td>
			<s:property value="request_date"/>
		</td>
		<s:if test="status == 2">
		<td>
			<a  href="/sizaikanri/order/act?form.sizaiId=<s:property value="id"/>">発注</a>
		</td>
		</s:if>
		<s:else>
		<td>
			<font color="red">発注済</font>
		</td>
		</s:else>


	</tr>
	</s:iterator>
	</table>
	</s:if>

<iframe  name="under" width="100%" height="400" frameborder="no" >
</iframe>
</body>