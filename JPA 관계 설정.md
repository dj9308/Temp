## JPA 관계 설정

- 엔터티 또는 도메인들은 각각 관계를 맺고 있음.
- JPA에서 관계 설정을 하게 되면 알아서 객체에서는 참조를 사용해서 관계를 맺고 테이블은 외래 키를 통해 관계를 맺은 후 서로 매핑을 함. 
- 이렇게 되면 개발자는 객체간의 관계 또는 그 사이에서 생성되어야만 하는 SQL문들을 신경 쓸 필요 없이 객체 간의 관계만 신경 쓰면 되기 때문.





- 방향 : 단방향, 양방향으로 관계 가능. 방향은 객체 관계에만 존재하고 테이블 관계는 향상 양방향.
- 연관관계의 주인 : 객체를 양방향 연관 관계로 만들면 연관관계의 주인을 정해야 함. 이 경우 보통 외래 키를 관리하는 엔터티가 주인이 됨.

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorate="~{layout/base}">
<head>
<title>Polestar Board</title>
</head>
<body>
<div layout:fragment="page_content" id="page_content">
	<div class="container">
		<div class="row py-4">
			<div class="col">
				<h1>게시글 생성</h1>
				<hr>
				<form action="/boards/create" method="post">
			<div class="form-group">
				<label for="form">게시판 종류</label> <input type="number"
					class="form-control" id="types.id" name="types.id">
			</div>
			<div class="form-group">
				<label for="form">Title:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter Title"
					name="title">
			</div>
			<div class="form-group">
				<label for="form">contents:</label>
				<textarea rows="20" cols="100" id="contents"
					placeholder="Enter contents" name="contents"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<button class='float-right btn btn-primary' onclick="location.href='/boards/'">목록보기</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>