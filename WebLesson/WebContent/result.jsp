<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String English = (String)session.getAttribute("English"); %>
<% String Japanese = (String)session.getAttribute("Japanese"); %>
<% int count = (int)request.getAttribute("recordNum"); %>
<% int dataNum = (int)request.getAttribute("dataCnt"); %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>登録画面</title>
</head>

<body>


<p><%=count %>件登録しました。</p>
<p>登録件数は<%=dataNum %>件です。</p>


<a href="index.jsp">トップに戻る</a>

</body>
</html>