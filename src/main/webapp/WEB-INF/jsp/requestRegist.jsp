<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<html>
<head>
<title>購入依頼登録</title>
</head>
<body>
	<h2>購入依頼登録</h2>
<font color="blue">購入理由、補足事項を備考欄に記載してください。</font>
	<form name="registform" action="/sizaikanri/requestRegist/regist" method="post">
		<table class="inputtable">
			<tr>
				<td>資材名</td>
				<td><input type="text" name="form.sizaiDto.name"
					value="<s:property value="form.sizaiDto.name"/>" /></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input type="number" name="form.sizaiDto.num"
					value="<s:property value="form.sizaiDto.num"/>" /></td>
			</tr>
			<tr><s:select name="form.sizaiDto.category_id" label="カテゴリ"
						list="form.categoryList" listKey="id" listValue="name" />

			</tr>
			<tr>
				<td>備考</td>
				<td><textarea name="form.sizaiDto.note"><s:property value="form.sizaiDto.note"/></textarea></td>
			</tr>
		</table>

	<input type="submit" value="登録"/><input type="reset" value="クリア"/><br/>
	<a href="/sizaikanri/requestList/init">一覧へ戻る</a>
	</form>
</body>
</html>