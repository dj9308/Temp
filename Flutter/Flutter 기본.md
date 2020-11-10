# Flutter

## 기능 및 관련 단어

### Hot-load 기능

- 앱의 변경 내용만 저장하면 바로 Hot-reload 기능에 의해 바뀐 부분을 볼 수 있다.

### Scaffold

- 기본 meterial design의 시각 레이아웃 구조를 표현해 놓은 것이다.
- 스낵바 또는 영속적인 하단 시트를 보여주기 위해 사용한다.
- home 부분에 쓰인다.

### Widget

- 미니 응용 프로그램 이며, JSON과 매우 흡사하다. 단 dart에서는 {}는 쓰지 않는다.
- 함수의 파라미터로 함수의 결과를 넣는 방식의 JS와 비슷하다.
- Flutter에서 위젯은 불변이기 때문에 직접 변경할 수 없고, 대신 위젯의 state를 변경할 수 있다.

#### stateless widget

- 상태 정보가 없는 위젯.

- 작성하려는 사용자 인터페이스 부분이 구성 정보 외에 다른 어떤 정보에도 의존하지 않을 때 유용하다.

- ImageView로 로고를 배치하는 경우와 비슷하다. 로고는 실행중에 변경되지 않기 때문에, StatelessWidget을 사용한다.

- 또한 이벤트가 일어나지 않아도 되는 페이지일 경우, stateless를 사용한다.

- #### stateless, stateful 차이점

  - LifeCycle이 다르다.
  - 상호작용이 필요없는 Stateless의 LifeCycle이 더 빠르게 동작하므로 반응에 대한 비용을 절약할 수 있다.(속도가 빠르다)
  - stateful의 경우, 상호작용이 필욯나 부분은 사용자와 상호작용시마다 상태를 새로 업데이트해줘야 하기 때문에, LifeCycle 시간이 더 걸리게 된다.
  - 더 효율적인 개발을 위해 위와 같이 나눠진 것이다.

### MaterialApp()

- 구글이 지향하는 Material Design을 사용할 수 있게 해주는 class이다.
- Scaffold 위젯을 사용할 수 있다. 기본적인 앱의 디자인 및 설정을 할 수 있다.
- Meterial Design : 플랫 디자인의 장점을 살리면서도 빛에 따른 종이의 그림자 효과를 이용해 입체감을 살리는 디자인 방식
- Material app 대신에 container를 쓸 수 있다.
- title, theme

### child, chilren

- child : 자손이 하나일 경우 : Center, Container 등
- children : 위젯 리스트를 가지고 있을 경우(여러개를 가질 수 있을 때). Row,Column,ListView, Stack

Material app

## Main.dart

- ```dart
  import 'dart:async';
  
  import 'package:flutter/material.dart';
  import 'package:flutter/services.dart';
  import 'package:flutter_android1/flutter_android1.dart';
  
  void main() { 
    runApp(MyApp()); // 위젯 추가
  }
  
  class MyApp extends StatefulWidget { //애플리케이션 루트
    @override
    _MyAppState createState() => _MyAppState();
  }
  
  class _MyAppState extends State<MyApp> {
    String _platformVersion = 'Unknown';
  
    @override
    void initState() {
      super.initState();
      initPlatformState();
    }
  
    // Platform messages are asynchronous, so we initialize in an async method.
    Future<void> initPlatformState() async {
      String platformVersion;
      // Platform messages may fail, so we use a try/catch PlatformException.
      try {
        platformVersion = await FlutterAndroid1.platformVersion;
      } on PlatformException {
        platformVersion = 'Failed to get platform version.';
      }
  
      // If the widget was removed from the tree while the asynchronous platform
      // message was in flight, we want to discard the reply rather than calling
      // setState to update our non-existent appearance.
      if (!mounted) return;
  
      setState(() {
        _platformVersion = platformVersion;
      });
    }
  
    @override
      //build라는 함수를 오버라이드해 내용을 넣어주고 있음.
    Widget build(BuildContext context) {
        // 안드로이드의 MaterialDesign을 사용한 App이라 MaterialApp을 반환함
        // MaterialApp은 main의 runApp에서 선언할 수 있음.
      return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
          visualDensity: VisualDensity.adaptivePlatformDensity,
        ),
        home: Scaffold( // 레이아웃 구성
            appBar: AppBar(title: Text('헬로 월드')),
            body: Text('헬로 월드', style: TextStyle(fontSize: 30))),
      );
    }
  }
  
  ```

- 