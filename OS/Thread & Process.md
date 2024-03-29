# Thread & Process

## 설명

- Process: 프로그램을 메모리 상에서 실행 중인 작업
- Thread : 프로세스 안에서 실행되는 여러 흐름 단위
- 기본적으로 프로세스마다 최소 한 개의 Thread를 소유한다.

![img](https://camo.githubusercontent.com/3dc4ad61f03160c310a855a4bd68a9f2a2c9a4c7/68747470733a2f2f74312e6461756d63646e2e6e65742f6366696c652f746973746f72792f393938383931343635433637433330363036)

- 프로세스는 각각 별도의 주소 공간이 할당된다(메모리 영역)

  - CODE : 코드 자체를 구성하는 메모리 영역(독립적)

    - 프로그램을 작성하면 CODE 영역이 늘어난다.

  - Data : 전역변수, 정적 변수, array 및 초기화 된 데이터, static으로 선언된 변수

    - compile time에 code, data, bss는 크기가 결정되며 고정된다.

  - BSS : 전역변수, 초기값 없는 변수, static으로 선언된 변수

  - HEAP : 동적 할당으로 할당된 변수 (new(), malloc() 등)

  - STACK : 지역변수, 블록 내에서 할당된 변수

    - 지역변수를 프로그래밍하면서 얼마나 사용할지 미리 계산할 수 없다.

    - 함수의 뒷부분에서 부터 변수의 주소가 매겨진다. 

      즉, 변수 선언 순서에 딸 ㅏ높은 주소에서 낮은 주소로 내려간다.

- 메모리 할당 예제

  1. 코드 작성 : if(...) => JVM => 기계어 변환 => 기계어가 code에 채워진다.
  2. int A; => 지역변수이므로 STACK에 4byte 공간을 만들라는 뜻이다.
     실행파일에는 A가 없고  A를 만들라는 지시만 있다. A는 실행시킬 때 생성된다.
  3. hard disk에 code, data, bss가 들어있다. (실행파일 .exe)
  4. 실행파일을 실행한면 bss가 메모리에 들어가 stack 시작점을 생성하고 코드를 읽어들인다.
  5. 이후 로더로 해당 프로세스를 메모리에 로딩한다.

- Thread는 Stack만 따로 할당 받고 나머지 영역은 서로 공유한다.

- 하나의 프로세스가 생성될 때, 기본적으로 하나의 스레드를 같이 생성한다.

- 프로세스는 자신만의 고유 공간과 자원을 할당받아 사용하는 것에 반해, 스레드는 다른 스레드와 공간, 자원을 공유하면서 사용하는 차이가 존재한다.

## Multi Process

- 하나의 프로그램을 여려개의 프로세스로 구성해서 각 프로세스가 병렬 형식으로 작업을 수행하는 것.
- 장점 : 안정성(메모리 침범 문제를 OS차원에서 해결)
- 단점 : 각각 독립된 메모리 영역을 갖고 있기 때문에, 작업량이 많을 수록 오버헤드 발생. 또한 context switching으로 인한 성능 저하.
  - Overhead : 단순 작업 대비 추가 작업을 동시 수행시 발생하는 지연 시간 또는 메모리
  - Context Switching : CPU가 여러 작업을 공유할 수 있게 하기 위해 현재 Context를 잠시 중단하고 다른 Context를 실행하는 것 

## Multi Thread

- 하나의 응용 프로그램에서 여러 스레드를 구성해 각 스레드가 하나의 작업을 처리하는 것.
- 웹상의 멀티 스레드 설정의 경우, WAS에서 tread pool을 설정함으로써 이를 수행한다.
- 장점 : 독립적인 프로세스에 비해 공유 메모리만큼의 시간, 자원 손실이 감소하며 전역변수와 정적 변수에 대해 자료를 공유 가능하다.
- 단점 : 안전성 문제가 존재한다. 하나의 스레드가 데이터 공간을 망가뜨리면 공유 메모리를 갖기 때문에 모든 스레드가 작동 불능 상태가 된다.
  - 해당 단점은 Critical Section 기법을 통해 대비할 수 있다.
    Critical Section : 하나의 스레드가 공유 데이터 값을 변경하는 시점에 다른 스레드가 그 값을 읽으려 할 때, 발생하는 문제를 해결하기 위한 동기 화 과정.

## 참고

- [github 기술면접](https://github.com/gyoogle/tech-interview-for-developer/blob/master/Computer%20Science/Operating%20System/Process%20vs%20Thread.md)
- [메모리 영역](https://donghwada.tistory.com/entry/%EB%A9%94%EB%AA%A8%EB%A6%AC-%EC%98%81%EC%97%AD-Code-Data-BSS-HEAP-Stack-Little-Endian-Stack%EC%9D%98-%EC%9D%B4%ED%95%B4)