## [JDBC 프로그래밍 정리]

ODBC --> C, C++

- JDBC API(interface) + JDBC Driver

   java.sql						DB서버에 따로 추가로 준비

- JDBC 프로그램의 구현 과정

  - JDBC 드라이버 로딩(Class.forName(대표클래스 이름))

  - DB서버 접속 (DriverManager.getConnection(JDBCURL,ID,PASSWD))

  - Statement, PreparedStatement 객체 생성  //  connection의 ===

  - executequery(),executeUpdate()  // execute 툴

    ​	rusultSet			int

    next(),getXxx()	변화된 행의 갯수 

    

  - 연결된 자원 해제 : close() 





## [웹 프로그래밍]

웹 클라이언트 : HTML, CSS, JavaScript, Ajax HTML5 주요 API

웹 서버 :  Servlet & JSP, Spring FW, MyBatis

웹기반 시각화 : D3.js

오픈 API 네이버 또는 구글

웹서버 - Tocat 

웹 클라이언트 - 크롬

http://tomcat.apache.org/

javaexam - java project

edu - Dynamic web Project

1. Tomcat 서버를 eclipse에 등록

2. edu 생성

3. edu를 Tomcat 서버에 등록

4. first.html 파일을 생성

5. 브라우저(크롬)에서 first.html 요청

   http://localhost:8000/edu/first.html



tomcat 설치 후

이클립스에 server -tomcat 9.0 설치 

dynamic web project 에 edu, 마지막에 체크박스 체크

이후 edu 오른쪽클릭후 properties 누르고 utf-8로 설정

이후 결과창의 servers 선택후 add and remove 선택후 edu 오른쪽으로 밀어넣기  //서버 설정

edu 하위 항목의 webcontent 오른쪽클릭후 html 파일 선택

