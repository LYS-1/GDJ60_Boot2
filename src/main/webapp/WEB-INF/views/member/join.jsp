<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<div class="containerfluid">
		<div>
			<label class="form-label" for="memberID">아이디</label>
			<input type="text" class="form-control" id="memberID" name="id">
		</div>
		<div>
			<label class="form-label" for="memberPw1">비밀번호</label>
			<input type="password" class="form-control" id="memberPw1" name="pw1">
		</div>
		<div>
			<label class="form-label" for="memberPw2">비밀번호</label>
			<input type="password" class="form-control" id="memberPw2" name="pw2">
		</div>
		<div>
			<label class="form-label" for="name">이름</label>
			<input type="password" class="form-control" id="name" name="name">
		</div>
		<div>
			<label class="form-label" for="email">이메일</label>
			<input type="password" class="form-control" id="email" name="email">
		</div>
		<div>
			<label class="form-label" for="birth">생일?</label>
			<input type="date" class="form-control" id="birth" name ="birth"  placeholder="birth">
		</div>
		
	</div>
	<button id="join">joinbutton</button>
	<script src="../js/joinFormCheck.js"></script>
	
</body>
</html>