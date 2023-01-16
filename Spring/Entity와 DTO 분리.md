# Entity와 DTO 분리

Entity와 DTO를 정보 및 분리하는 이유를 설명하는 문서.



## 문제

---

![image-20230113125558101](C:\Users\dj930\AppData\Roaming\Typora\typora-user-images\image-20230113125558101.png)

위의 사진과 같이 파라미터가 알맞은 형식으로 들어왔는지 확인하기 위해 Entity Class에 Validation을 걸 경우, Entity하나에 과도한 역할을 수행하며 상황에 따라 역할 충돌로 인해 오류가 날 것 같아 Entity와 DTO의 분리하는 법을 찾게 되었다.



 ## 정의

---

![img](https://velog.velcdn.com/images%2Fboo105%2Fpost%2F7f310f77-2ff2-44c5-9365-e79b64b0226e%2Fimage.png)

### Entity

- DB 테이블에 존재하는 Column들을 필드로 가지는 객체이다.
- Entity는 DB의 테이블과 1:1로 대응되며, 그로 인해 테이블이 가지지 않는 컬럼을 필드로 가져서는 안된다.
- 다른 클래스를 상속받거나 인터페이스의 구현체여서도 안된다.

### DTO

- Data Transfer Object의 약자이며, 계층간 데이터 교환 역할을 담당한다.
- Entity를 Controller 같은 클라이언트단과 직접 마주하는 계층에 직접 전달하는 대신 DTO를 사용해 데이터를 교환한다.
- DTO는 단지 계층간 데이터 교환이 이루어 질 수 있도록 하는 객체로, 특별한 로직을 가지지 않는 순수한 데이터 객체여야 한다.



## 분리하는 이유

---

#### Entity와 DTO를 분리해야 하는 가장 근본적인 이유는 관심사가 서로 다르기 때문이다.
관심사의 분리(separation of concerns, SoC)는 소프트웨어 분야의 오래된 원칙 중 하나로써, 서로 다른 관심사들을 분리하여 변경 가능성을 최소화하고, 유연하며 확장가능한 클린 아키텍처를 구축하도록 도와준다.

DTO의 주요 관심사는 데이터의 전달이다. DTO는 데이터를 담아서 다른 계층 또는 다른 컴포넌트들로 데이터를 넘겨주기 위한 자료구조이다. 그외 기능이나 동작은 없어야 한다.

Entity는 비즈니스 로직을 담는 비즈니스 도메인 영역의 일부이다. 그러므로 Entity 또는 도메인 객체는 그에 따른 비지니스 로직이 추가될 수 있다. Entity 또는 도메인 객체는 다른 계층이나 컴포넌트들 사이에서 전달을 위해 사용되는 객체가 아니다.

Entity의 값이 변하면 Repository 클래스의 Entity Manager의 flush가 호출될 때 DB에 값이 반영되고, 이는 다른 로직들에게도 영향을 미친다. View와 통신하면서 필연적으로 데이터의 변경이 많은 DTO클래스를 분리해야 한다.



## 출처

- [Panda.log](https://velog.io/@boo105/Entitiy-%EC%99%80-DTO-%EC%9D%98-%EB%B6%84%EB%A6%AC)
