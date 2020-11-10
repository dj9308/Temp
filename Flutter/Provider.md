# Provider

## 정의 및 쓰는 이유

- 데이터 공유 및 로직의 분리를 위해 고안된 플러그인이다.(Bloc 패턴과 비슷하다.)

- 일종의 VO / DTO

  ### 관심사의 분리

  - 코드의 역할에 따라 나누어 관리 및 유지보수를 쉽게 할 수 있다.
  - 그 결과, 좀 더 간결한 코드가 나올 수 있다.

  ### 데이터의 공유

  - 여러 페이지에서 하나의 데이터를 공유하고 싶을 때 사용한다.

## 프로바이더 구조

- provider는 data를 생산하고 소비하는 2부분으로 되어 있다.

- 어떤 데이터를 생산하는 것에 따라 Provider 종류도 달라진다.

  - Provider, StreamProvider

- 라이브러리 추가

  - ```
    provider: ^3.0.0+1
    ```

- Provider 데이터 생산

  - ```dart
    Provider<int>.value( // int 타입 사용
          value: 5,
          child: Container(),
    )
        // 데이터 생산시 꼭 데이터 타입을 적는다.(여기선 int형)
    ```

- Provider 데이터 소비

  - ```dart
    var data = Provider.of<int>(context) // int 타입 사용. Provider를 만들 때 int 타입을 썼기 때문
    ```

  - Provider가 제공하는 데이터를 쓰려면 ***Provider.of(context)\*** 나 ***Consumer()\*** 위젯을 사용한다.

  - 





