# Thymeleaf & JPA

## 2. ThymeLeaf vs jsp

- 둘다 템플릿 엔진의 일종이다. (템플릿 엔진: 템플릿 양식 + 데이터 조합해서 화면 표현해주는 컴포넌트 또는 소프트웨어)
- jsp의 경우 jar 패키징이 불가하기 때문에 jar 파일로 배포하는 boot 입장에선 TymeLeaf를 권장한다.
- jsp의 경우 서블릿으로 변환되어 실행된다. 즉, 자바로 변환되어 실행되기 때문에 무거울 수 있으며 비즈니스 로직이 분리가 안되는 반면, 타임리프는 서블릿으로 변환하지 않다보니 비즈니스 로직이 분리된다.

## 3. JPA vs Mybatis

- Java persistence API의 약자로 Java ORM 기술에 대한 API 표준 명세를 말한다.
- ORM : Object Relational Mapping (객체 관계 매핑) / 객체와 RDMBS 데이터를 자동으로 매핑해주는 것.
  - 객체지향 프로그래밍은 클래스를 사용하고, RDBMS는 테이블을 사용하기 때문에 모델간 불일치가 존재한다.
  - ORM은 객체간 관계를 바탕으로 SQL을 자동으로 생성해서 불일치를 해결한다.
- JPA는 단순한 명세이기 대문에 JPA만 가지고는 어떤 구현 기술을 사용할 수 없다.
- 실제로 우리는 Spring Data JPA를 쓰는 것이며, 이는 JPA를 간편하게 사용하도록 만들어놓은 오픈 소스이다. 또한 
- Hibernate는 JPA의 구현체
- Spring Data JPA는 JPA를 쓰기 편하게 만들어놓은 모듈
- SQL MAPPER : Object 와 sql field를 매핑시켜주는 기술
