# Thymeleaf

## 정의

- 템플릿 엔진. th:xx형식으로 속성을 html 태그에 추가하여 값이나 처리 등을 페이지에 심을 수 있다.
- JSP, 그루비 등 다른 템플릿도 스프링 부트에서 사용 가능하지만 타임리프가 제일 많이 쓰인다고 한다.

## JSP와의 공통점 및 차이점

- Thymeleaf와 jsp은 둘다 서버사이드 랜더링을 지원하는 템플릿 엔진이다.
  - 템플릿 엔진 : 템플릿 양식과 서버에서 가져온 데이터를 조합해서 화면에 표현해주는 컴포넌트 또는 소프트웨어
- jsp는 jar 패키징이 불가하기 때문에 jar 파일 배포가 가능한 boot입장에선 Thymeleaf를 권장한다.
- JSP의 경우 서블릿, 즉 자바로 변환되어 실행되기 때문에 무거울 수 있으며 비즈니스 로직이 분리가 안되는 반면, 타임리프는 서블릿으로 변환하지 않다보니 비즈니스 로직이 분리된다.
- Thymeleaf의 경우 핵심 기능인 Natural Template을 통해 제공해주는데, 이는 서버 사이드 렌더링을 하는데 필요한 데이터가 없더라도 프로토타입으로서의 역할을 해줄 수 있는 걸 말한다.
  - 때문에, 타임리프의 경우 파일을 열어도 html 형식으로 바로 확인이 가능해서 리뷰하기 유용하다.
  - JSP의 경우 JSP 소스코드와 HTML이 섞여있어 렌더링 전까지 파일 내용을 확인하기 힘들다.

## 식

- 변수식 : ${}

- 메시지식 : #{}

  - resources 파일에 예시인 messages.properties 파일을 생성 후 내용 수정.

  - ```
    content.id=strongstar
    content.name=dongjae
    ```

    ```html
    <body>
        <h1 th:text="#{content.id}"></h1>
        <h1 th:text="#{content.name}"></h1>
    </body>
    ```

    

- 링크식: @{}

  - ```html
    <a th:href="@{'/home/'+${param.id[0]}}">
    ```

- 객체의 변수식 : *{}

  - ```java
    class test{
        public int id;
        public String name;
    }
    ```

    ```html
    <p th:text="*{id}"></p>
    <p th:text="*{name}"></p>
    ```

- 리터럴 치환 ||

  - ```html
    <h1 th:text="#{content.id}"></h1>
    	<p th:text="|id : *{id}, name : *{name}|"></p>
    ```

  - id : 123 name : star

## 문법

| Title                  | Description                                                  |
| ---------------------- | ------------------------------------------------------------ |
| th:text                | 텍스트 내용<br /><span th:text="${user.name}"></span>        |
| th:utext               | html 내용<br /><div th:utext="${content}"></div>             |
| th:value               | element value 값, checkbox, input 등<br /><input type="text" th:value="${title}" /> |
| th:with                | 변수값 지정<br /><p th:with="authType = ${user.authType}+' Type'" th:text="${authType}"></p> |
| th:switch<br />th:case | switch - case 문<br /><div th:switch="${user.role}"><br/><br/>   <p th:case="'admin'">User is an administrator<br/><br/>   <p th:case="#{roles.manager}">User is a manager |
| th:if                  | 조건문<br /><p th:if="${user.authType}=='web'" th:text="${user.authType}"></p> |
| th:unless              | else 표현<br /><p th:unless="${user.authType}=='facebook'" th:text="'not '+ ${user.authType}"></p> |
| th:each                | 반복문<br /><p th:each="user : ${users}" th:text="${user.name}"></p> |
|                        |                                                              |



