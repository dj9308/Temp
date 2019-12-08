# Spring Boot

## 기본 지식

- 스프링 프레임워크를 기반으로 개발을 할 때 기존 일반 스프링 환경에 비해서 개발 환경을 쉽게 구축이 가능하다
- 단독 실행이 가능한 수준의 스프링 어플리케이션 개발 가능
- 내장된 톰캣, Jetty, UnderTow등의 서버를 이용해서 서버설치 없이 실행이 가능
- 자동화된 설정방식을 제공, 코드 생산성이 뛰어나다
- 기존 스프링 환경에서 설정했던 XML없이 단순 자바수준의 설정 방식을 제공
- MAVEN, gradle의 환경을 제공해준다.
- NoSQL, AWS등의 환경도 자동으로 제공된다.
- Spring Framework + Embedded HTTP Servers(Tomcat) - XML<bean> @configuration = Spring Boot

### 단점

- 부트환경에서 제공이 되지 않는 라이브러리들도 존재할 수 있고 프레임우크 차이로 문제가 있을 수 있음 => 적절하게 취사 선택해야 함.

## 프로젝트 생성 방법

1. Spring Starter Project 선택 

2. Type, Package, Java Version, Language 설정 등을 프로그램의 목적에 맞게 변경하면 됨. (Maven으로 하는방법 및 추가적으로 Gradle이 있다.)
   Groovy로 관리가 되기에 효율적으로 관리가 가능하다.
3. 프로젝트 옵션 설정 : NoSQL, AWS 등 다양한 환경 설정 가능하며 나중에 라이브러리 추가가 가능하다.
4. 프로젝트 사이트 정보 : 기본적으로 프로젝트 Url을 설정하는 부분. 기본적으로 세팅되는 값을 가급적 꼭 필요하지 않으면 변경하지 않는다.
5. 기본 프로젝트 구조 
   - Java부분에는 MVC 관련 패키지를 정의해준다.
   - application 패키지에는 스프링을 단독 실행할 수 있는 클래스 파일이 있다.
   - config 파일은 기존 xml에서 설정했던 여러 정보들을 자바 코드로 설정하는 클래스들을 정의한 패키지이다.
   - 나머지는 controller, dao, service 등 MVC에 필요한 패키지이다.
   - MVC 관련 패키지들은 반드시 @SpringBootApplication 패키지(루트 패키지)의 하위 패키지에 있어야 정상적인 Component Scan이 가능하다. 
   - resources에는 sql쿼리문이 작성되는 mapper파일, css, js, image 등의 정적파일들이 저장되는 static 파일, 스프링 부트에서 환경설정을 위한 application properties가 있다
   - 처음 생성시 src에는 하위로 webapp까지 밖에 없다. 따라서 추가적으로 스프링 프레임워크 환경과 동일하게 하기 위해 WEB-INF를 만들어주고 하위에 views등의 파일을 만들어준다.

http://blog.naver.com/PostView.nhn?blogId=scw0531&logNo=221066404723&parentCategoryNo=&categoryNo=18&viewDate=&isShowPopularPosts=true&from=search