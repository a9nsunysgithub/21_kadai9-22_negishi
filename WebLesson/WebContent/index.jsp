<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>辞書</title>
<meta charset="UTF-8">
</head>
<body>

<h1>英単語、日本語を登録してください</h1>

<form action="regist" method="post">
<p>
英単語：<input type="text" name="english" id="english_id" size="40">
</p>
<p>
日本語：<input type="text" name="japanese" id="japanese_id" size="40">
</p>

<p>
<input type="submit" value="送信"><input type="reset" value="リセット">
</p>
</form>

</body>
</html>