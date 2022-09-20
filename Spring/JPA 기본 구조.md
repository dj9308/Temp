# JPA

## 정의 및 특징

- Java persistence API 의 약자. Java ORM 기술에 대한 API 표준 명세를 말한다.

- ORM : Object Relational Mapping (객체 관계 매핑) / 객체와 RDBMS 테이블을 자동으로 매핑해주는 것.

  - 객체지향 프로그래밍은 클래스를 사용하고, RDBMS는 테이블을 사용하기 때문에 모델간 불일치가 존재한다.
  - ORM은 객체간 관계를 바탕으로 SQL을 자동으로 생성해서 불일치를 해결한다.
  - ORM의 경우 직접 쿼리를 작성하지 않고도 객체가 DB에 접근할 수 있다.
  - 

- JPA는 단순한 명세이기 때문에 JPA만 가지고는 어떤 기술을 사용할 수 없다.

- 실제로 우리는 Spring Data JPA를 사용하는 것이며, 이는 JPA를 간편하게 사용할 수 있도록 만들어놓은 오픈소스이다.

- Hibernate (ORM 프레임워크)는 JPA의 구현체이다.

  - Hibernate : DB의 데이터와 코드를 매핑시켜주는 프레임워크. 비슷한 것이 mybatis이다.
  - mybatis는 JDBC 드라이버를 사용해 자바 코드와 DB를 매핑해주었다.

- ORM과 SQL MAPPER의 차이점

  - SQL mapper의 경우 직접 SQL 쿼리문을 작성해야 하기 때문에 보안 및 유지보수가 힘들다.
  - 반면 데이터 필터링이 SQL mapper가 높기 때문에 성능면에서는 SQL mapper가 높을 수 있다.

  

## Entity 

- 데이터베이스에 저장하기 위해 정의한 클래스(Domain)
- RDBMS에서 Table을 객체화 시킨 것.
- Table의 이름이나 컬럼들에 대한 정보를 가진다.

- @Id : primary key를 가지는 변수를 선언하는 것을 뜻함.
  @GeneratedValue 어노테이션은 해당 ID값을 어떻게 자동으로 생성할지 전략을 선택할 수 있다. 여기서 선택한 전략은 "AUTO"이다.
- @Table : 별도의 이름을 가진 데이터베이스 테이블과 매핑한다. @Entity로 선언된 클래스의 이름은 실제 데이터베이스의 테이블 명과 일치하는 것을 매핑한다. 따라서 @Entity의 클래스명과 데이터베이스의 테이블명이 다를 경우에 @Table(name=" ")과 같은 형식을 이용해서 매핑이 가능하다.
- @Column : 필수는 아니지만 지정한 변수명과 데이터베이스의 컬럼명을 서로 다르게 주고 싶다면 @Column(name=" ")과 같은 형식으로 작성하면 된다. 그렇지 않을 경우 멤버 변수명과 일치하는 데이터베이스 컬럼을 매핑한다.

```java
public interface GuestbookRepository extends JpaRepository<Guestbook, Integer>{
// entity의 형식 / interger: id의 타입
}
```



## Repository

- Entity의 기본적인 CRUD가 가능하도록 JpaRepository 인터페이스를 제공한다.

- JpaRepository 인터페이스를 상속하기만 해도 되며, 인터페이스에 따로 @Repository 등의 어노테이션을 추가할 필요가 없다.

- JpaRepository를 상속받을 때는 사용될 Entity 클래스와 ID값이 들어가게 된다. 

- Spring Data JPA가 제공하는 메서드

- |  method   |                       기능                       |
  | :-------: | :----------------------------------------------: |
  |  save()   |   새로운 entity 저장, 이미 있는 entity는 수정    |
  | findOne() |          primary key로 레코드 한건 찾기          |
  | findAll() | 전체 레코드 불러오기. 정렬(sort), 페이징(paging) |
  |  count()  |                   레코드 갯수                    |
  | delete()  |                 레코드 하나 삭제                 |

  

- 또다른 조회기능 추가하고 싶으면 규칙에 맞는 메서드를 추가해야한다.

- 

  | method         | 설명                                           |
  | -------------- | ---------------------------------------------- |
  | findBy로 시작  | 쿼리를 요청하는 메서드임을 알림                |
  | countBy로 시작 | 쿼리 결과 레코드 수를 요청하는 메서드임을 알림 |

- findBy에 이어 해당 Entity 필드 이름을 입력하면 검색 쿼리를 실행한 결과를 전달한다. SQL의 where절을 메서드 이름을 통해 전달한다고 생각하면 된다.

- 메서드 반환형이 Entity 객체이면 하나의 결과만을 전달하고, 반환형이 List라면 쿼리에 해당하는 모든 객체를 전달한다.

- Pageable : Query 메소드의 입력변수로 Pageable 변수 추가하면 Page 타입을 반환형으로 사용할 수 있다.

- Pageable 객체를 통해 페이징과 정렬을 위한 파라미터를 전달한다.

- | query parameter 명 | 설명                                                         |
  | ------------------ | ------------------------------------------------------------ |
  | page               | 몇번째 페이지 인지를 전달                                    |
  | size               | 한 페이지에 몇개의 항목을 보여줄 것인지 전달                 |
  | sort               | 정렬정보를 전달. 정렬정보는 필드 이름, 정렬방향의 포맷으로 전달한다. 여러필드로 순차적으로 정렬도 가능하다.<br /> 예: sort=createdAt,desc&sort=userId,asc |



http://wonwoo.ml/index.php/post/1980