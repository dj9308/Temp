# Spring 기본 지식

## Spring 기본 용어 및 정보

- Maven: 자바 프로젝트의 빌드(build)를 자동화 해주는 빌드 툴(build tool)
  자바 소스를 compile하고 package해서 deploy하는 일을 자동화 해주는 것.
- Maven이 참조하는 설정 파일
  1. settings.xml
     - maven tool 자체에 관련된 설정 담당.
  2. pom.xml
     - POM(Project Object Model)을 설정하는 부분으로 프로젝트 내 빌드 옵션을 설정하는 부분.

Simple Project와 Spring MVC Project의 차이점

- Simple Project : 기본 Spring 구성 및 프로젝트 본성을 사용하여 Java 빌드를 이용해 간단한 Spring 프로젝트 작성.
- Simple Spring Maven : Spring 라이브러리의 기본 세트를 포함하는 Maven을 사용하여 간단한 Spring 프로젝트 생성.
- 기본적으로 MVC 형태로 메이븐까지 셋팅이 되어 생성.
- 

## Spring boot

- 정의 : 이클립스 기반 스프링 애플리케이션을 개발하기 위한 개발 환경을 의미하며 오픈소스이다.
- Spring legacy : 일반적인 Spring Framework 프로젝트이다.
- Spring Starter Project : Spring boot라는 응용 프로그램의 빠른 개발 프레임워크를 이용한 프로젝트이다. 간단한 라이브러리 추가만으로 필요한 프레임워크들이 모두 포함되는 것이 가능하다.
- Spring legacy 와 Spring boot의 차이점:
  1. Spring boot의 경우 웹 컨테이너(Tomcat)를 내장하고 있다.
  2. 최소한의 설정으로 쉽게 Spring Application을 만들기 위한 목적으로 설계된 프레임워크 내의 플랫폼이라 할 수 있다.
  3. Spring boot로 Set up 할 경우 편리하게 Dependency 문제가 해결되고, 빠르게 웹 어플리케이션을 만들 수 있다.
  4. 반면 Spring boot 위에서 동작하기 때문에 확장성 등에 있어 모든 부분을 직접 설정해주어야 한다.
  5. 버전 호환 문제가 아직 존재해 REST나 JPA 이용을 위해 Spring boot 1.4 이상의 버전이 필요하다.
  6. Spring boot 버전에 따라 내장 톰캣의 버전에 차이가 생기게 된다.(Spring boot 1.2.4 이상은 Tomcat8, 이하는 Tomcat 7 버전이 사용.)
  7. 때문에 각 버전간 호환을 맞춰야 한다. 그렇지 않으면 바로 LifeCycle 에러 발생.
  8. 기본으로 설정된 Embed 톰캣 사용 설정을 하지 않게 명시해서 외장 톰캣 사용도 가능하다.