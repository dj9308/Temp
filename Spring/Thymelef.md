# Thymelef

## 정의

- 템플릿 엔진. th:xx형식으로 속성을 html 태그에 추가하여 값이나 처리 등을 페이지에 심을 수 있다.
- JSP, 그루비 등 다른 템플릿도 스프링 부트에서 사용 가능하지만 타임리프가 제일 많이 쓰인다고 한다.
- 

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



