# Stream

- 반응형 프로그램의 기초 중 하나.

-  비동기적으로 단일 값이 아닌 여러가지 오류나 데이터를 가져온다.

- future처럼 사전에 결정해야 하며, 데이터 조각이 준비가 되고 오류가 생성되며, 스트림이 완성되면 준비가 끝난다.

- 이벤트 루프는 여전히 실행된다.

  - ex:) 파일의 데이터를 읽고자 files.openRead를 이용하면 하나의 stream을 돌려보낸다.
  - 수많은 데이터가 디스크에서 읽히고 이벤트 루프에 도착하게 된다.
  - 스트림에 데이터를 추가하고 앱 코드에 띄우게 된다.
  - 다른 데이터 조각이 도착하면 기존 것이 나가고 새로운 것이 들어온다.
  - 타이머 기반의 스트림과 네트워크 소켓에서 온 스트리밍 데이터 모두 시계와 네트워크 이벤트를 이용해 이벤트 루프와 함께 작동한다.

- ```dart
  // stream 기본 사항
  
  final myStream = NumberCreator()
      .stream // 디폴트로 단일 사용을 위한 스트림이 준비됨.
      .asBroadcastStream; // 해당 함수를 사용하면 다중 사용이 가능해짐.
  	// 디폴트로 초마다 stream이 수행됨.
  final subscription = myStream.listen(
  	(data) => {
          print('Data: $data');
      },
  	onError:(err){  //에러 로그
      	print(err);
  	},
      cancleOnError: false, // false시, 오류가 있어도 수행가능함.
      onDone(){	// stream이 끝날 시 출력
          print('Done!');
      }
  );
  
  subscription.pause();  // stream 선언시 해당 변수는 상태 설정 가능
  subscription.resume();
  subscription.cancel();
  
  final subscription2 = myStream.listen( // asBroadcastStream으로 동시에 stream 사용 가능
  	(data) => print('Data: $data'),
  );
  ```

- ``` dart
  // stream 조작
  
   NumberCreator().stream
       // boolean
       .where((i)=> i%2 == 0)
       // map: stream에서 각 값을 가져와 즉각적으로 다른 것으로 변환하기 위해 사용.
       .map((i) => 'String $i')
       // listen으로 하나의 stream으로 연결
       // print함수에 도착할 때 직접적으로, 비동기적으로 스트림 밖으로 출력하게 되는 것.
       .listen(print); 
  //result : String 2 / String 4 ...
  
  // reduxStore를 사용하는 앱이면 onChange 스트림 안의 새로운 앱 객체를 내보낸다.
  myReduxStore.onChange 
      //map: 해당 객체 상태의 스트림을 MyViewModel의 스트림으로 전환  
      .map((s)=> MyViewModel(s)) 
      //연속적으로 동일한 값을 걸러내는 스트림
      // 새 MyViewModel을 얻을 때마다 listen 사용 후 UI 업데이트
      .distinct()
      .listen(/* update UI */)
  ```

- ```dart
  class NumberCreator{
      NumberCreator(){
          // 타이머 : 1초
          Timer.periodic(Duration(seconds:1), (t){
             _controller.sink.add(_count);
             _count++;
          });
      }
      var _count = 1; //실행 갯수
      // StreamController로 나만의 스트림을 제작할 수 있다.
      final _controller = StreamController<int>();
      
      Stream<int> get stream =>
          _controller.stream;
  }
  ```

- 

## 알게된 사항

- $를 이용해 해당 value를 가져온다.
- 

