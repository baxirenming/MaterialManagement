<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>


<html>
<head>
</head>
<body>
<h4>詳細情報</h4>
	<table class="inputtable">
			<tr>
				<td>資材ID</td>
				<td>
					<s:property value="form.sizaiDto.id"/>
				</td>
			</tr>
			<tr>
				<td>資材名</td>
				<td><s:property value="form.sizaiDto.name"/></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><s:property value="form.sizaiDto.num"/></td>
			</tr>
			<tr>
				<td>購入依頼者</td>
				<td><s:property value="form.sizaiDto.request_user_name"/></td>
			</tr>
			<tr>
				<td>購入依頼部門</td>
				<td><s:property value="form.sizaiDto.request_dept_name"/></td>
			</tr>
			<tr>
				<td>状態</td>
				<td><s:property value="form.sizaiDto.status_name"/></td>
			</tr>
			<tr>
				<td>依頼日</td>
				<td><s:property value="form.sizaiDto.request_date"/></td>
			</tr>
			<tr>
				<td>備考</td>
				<td><s:property value="form.sizaiDto.note"/></td>
			</tr>
	</table>

</body>

</html>