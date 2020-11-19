# Isolate, Event Loop, Future

## Isolate

- Dart는 다른 언어와는 달리, 스레드가 메모리를 가진채로 isolate에 있다. 그리고 이벤트만 처리한다.
- 많은 Dart 앱은 단일 isolate에서 모든 코드를 실행한다. 필요하면 isolate를 더 많이 만들 수 있다.
- 실행해야 할 계산이 많거나 main isolate에 실행해야 할 경우에, Isolate.spawn이나 Flutter compute() 함수를 사용하면 된다.
  - 둘 다 개별 isolate를 만들어서 수 처리를 하며, 그동안 메인에 부담을 주지 않으며 위젯 트리를 다시 만들고 렌더링 한다.
- 그렇게 새로운 Isolate는 해당 메모리에서(기존의 isolate에서) 고유 이벤트 루프를 가지게 된다.
  - isolate끼리 서로 접근할 수 없다.
  - 정보를 주고받는 방법은 메세지를 서로 전달하는 것이다.
  - 한 isolate가 정보를 보내면 다른 한쪽은 이벤트를 사용하며 메시지를 처리한다.
  - 단일 thread에서 구현되기 때문에, 락이 필요없다.

## Event Loop

- 비동기 코드를 가능하게 하는 요소이다.

- 앱의 라이프사이클을 보면 시작과 끝 사이에 순서가 섞인 이벤트 들이 존재한다.

- 이것을 순서대로 실행하기 위해 Event Loop가 존재한다.

  - 이벤트 열이 빌때까지 오래된 이벤트 부터 차근차근 수행한다.

- future, 스트리밍 작업, 비동기 작업, 대기 또한 단순한 루프 주위에 만들어진 것이다.

- 이벤트 루프는 해당 함수의 하나하나를 보며 이벤트를 수행한다.

- 변수에 대한 이벤트 수행 후 .then((response){})를 수행하면 그것이 콜백 함수가 된다.

- ```dart
  final myFuture = http.get('www.naver.com'); 
  myFuture.then((response){ // 콜백 함수
      // 이경우, future는 네트워크 데이터를 기다리는 것.
      if(response.statusCode ==200){
          print('success!');
      }
  });
  //onPressed 와 future의 콜백은 결국 같다.
  //둘다 flutter에게 나중에 특정한 이벤트가 들어오면 해당 코드를 실행하라는 뜻이다.
  // dart의 입장에서 보면 둘다 열에 있는 이벤트일 뿐이다.
  ```

## Future

- Dart에서 비동기를 위해 있는 api (다른 언어에선 promise라고 불리기도 함)

- 데이터를 위한 작은 선물상자

- 누군가 상자가 닫힌 상태로 보내고 시간이 지나 상자가 열린다. - 안에는 값이나 에러가 존재한다.

- 이벤트 루프를 새용해 api를 훨씬 더 쉽게 이용할 수 있다. 이벤트 루프로 작동하여 단순화시킬 수 있다.

- future가 닫힌 상태로 오면 코드에서 then을 사용해 콜백을 등록한다.

  - 등록 하면 수행이 완료될 때까지 비동기 처리가 된다.(그 사이 어플이 백그라운드가 되도 실행 하도록 만들면 되지 않을까?) 실행 - 백그라운드 -실행 중 - 완료

- ``` dart
  final myFuture = http.get('www.naver.com'); // 네트워크 통신에서 future를 제공해주는 함수.
  final myFuture2 = SharedPreferences.getInstance; // 공유된 환경설정에 접근하는 것도 future를 제공함.
  myFuture.then((response){ 
      if(response.statusCode ==200){
          print('success!');
      }
  });
  ```

- ```dart
  import 'dart:async';
  
  void main(){ // 생성자를 사용
      final myFuture = Future((){ // 함수를 가지고 같은 유형의 future를 제공함.
          //그러면 나중에 비동기식으로 함수를 실행, 받은 값을 사용해 future를 완료한다.
          print('creating the future');
          return 12;
      });
      print ('Done');
  }
  ```

- ```dart
  // future의 값을 이미 알고 있는 경우엔 future.value를 사용해 생성자의 이름을 지을 수 있다. 여전히 비동기
  final myFuture = Future.value(12);
  // 에러가 있을경우 반환하는 방법
  final myFuture = Future.error(Exception());
  // 함수를 실행하고 future를 완료하기 전에 정해진시간까지 기다림.(loading spinner 테스트시 주로 사용)
  // 그 전까지 future는 미완료된 상태로 남음.
  final myFuture = Future.delayed(
  	Duration(seconds:5),
      ()=>12,
  );
  ```

- ```dart
  import 'dart:async';
  
  void main(){
      Future<int> delayed(
      Duration(seconds:3),  // 3초후
          (){return 100;},
      ).then((value){
          print(value); // value 값인 100 출력
      });
      print('waiting...');  // 1번째 출력
  }
  ```

- ```dart
  final myFuture = _fetchNameForId(12) //12 파라미터 입력 후 이름 반환
      .then((name) => _fetchCountForName(name)) // 파라미터 이름 입력후 count 반환
      .then((count)=>print(count)); count 출력
  ```

- ```dart
  Widget build(BuildContext context){
      // future와 builder 메소드를 제공하면 자동적으로 하위요소를 다시 만든다.
      return FutureBuilder<String>(
      	future: _fetchNetworkData(),
      	builder: (context,snapshot){
              //hasData함수로 값을 가진채로 완료되었는지 볼 수 있다.
              if(snapshot.hasData){
                  return Text(
                  	json.decode(snapshot.data)['delay_was']
                  );
              }
      	},
      ),
  }
  ```

- 

| sync:  |     int     | Iterator<int> |
| :----: | :---------: | :-----------: |
| Async: | Future<int> |  Stream<int>  |

