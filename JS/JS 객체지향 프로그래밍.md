# JS 객체지향 프로그래밍

## Core Object

- JS는 코어에 몇 개의 객체를 가지고 있다.
- Math, Object,  Array, String이 대표적이다.
- JS의 모든 객체는 Object 객체의 인스턴스이므로 Object의 모든 속성과 메소드를 상속받는다.

## Custom Object

### The Class

- JS는 class 문이 포함되지 않은 프로토타입 언어이다.

- JS는 function을 class로서 사용한다.

- ``` javascript
  function Person(){}
  ```

### The Object

- obj라는 이름의 객체의 새로운 인스턴스를 만들 때에는 new obj라는 statement를 사용하고, 차후에 접근할 수 있도록 변수에 결과를 받는다.

- ```javascript
  function Person(){}
  const person1 = new Person(); // 인스턴스화(객체 초기화)
  const person2 = new Person();
  ```

### The Constructor

- 생성자는 인스턴스화되는 순간 호출된다. 생성자는 해당 클래스의 메서드이다.

- JS에서는 함수 자체가 그 객체의 생성자 역할을 하기 때문에, 생성자 메서드를 정의할 필요가 없다.

- 클래스 안에 선언된 모든 내역은 인스턴스화되는 그 시간에 실행된다.

- 생성자는 주로 객체의 속성을 설정하거나, 사용하기 위해 객체를 준비시키는 메서드를 호출할 때 주로 사용된다.

- ```javascript
  function Person(){
      alert('Person instantiated');
  }
  const person1 = new Person(); // 인스턴스화 될 때 alert를 보여주게 된다.
  const person2 = new Person();
  ```

### The Property(object attribute)

- 속성은 클래스 안에 있는 변수들을 말한다. 객체의 모든 인스턴스는 그 인스턴스의 속성을 갖는다.

- 속성들의 상속이 바르게 이루어지려면 해당 클래스의 프로토타입이 선언되어 있어야 한다.

- 클래스 내에서 속성 작업은 현재 객체를 가리키는 this 키워드에 의해 이루어진다. 클래스의 외부에서 속성에 접근(읽기 혹은 쓰기)하는 것은 "인스턴스명.속성명" 형식으로 이루어진다.

- ```javascript
  function Person(gender) {
    this.gender = gender;
    alert('Person instantiated');
  }
  
  var person1 = new Person('Male');
  var person2 = new Person('Female');
  
  //display the person1 gender
  alert('person1 is a ' + person1.gender); // person1 is a Male
  ```

### Method

- Method는 function이기 때문에, function형태로 정의된다.

- Method를 호출하는 것은 속성에 접근하는 것과 매우 유사한데, 단지 끝에 ()를 추가하면 된다.

- method를 정의하기 위해서는 class의 prototype에 명명된 속성에 함수를 할당하면 된다. 이때 할당된 이름은 해당 객체의 메서드를 호출할 때 사용되는 이름이다.

- ```javascript
  function Person(gender) {
    this.gender = gender;
    alert('Person instantiated');
  }
  
  Person.prototype.sayHello = function()  // 메서드 정의
  {
    alert ('hello');
  };
  
  var person1 = new Person('Male');
  var person2 = new Person('Female');
  
  // call the Person sayHello method.
  person1.sayHello(); // 메서드 사용  : hello
  ```

- JS에서 Method는 context에 관계 없이 호출될 수 있는 속성으로서 클래스/객체에 연결돼 있다.

- ```javascript
  function Person(gender) {
    this.gender = gender;
  }
  
  Person.prototype.sayGender = function()
  {
    alert(this.gender);
  };
  
  var person1 = new Person('Male');
  var genderTeller = person1.sayGender;
  
  person1.sayGender(); // alerts 'Male'
  genderTeller(); // alerts undefined
  alert(genderTeller === person1.sayGender); // alerts true
  alert(genderTeller === Person.prototype.sayGender); // alerts true
  ```

### 상속

- JS에서는 부모 클래스의 인스턴스를 자식 클래스에 할당함으로써 상속이 이루어진다.

- Object.create 메서드를 사용해서 상속을 수행할 수 있다.

- ```javascript
  // define the Person Class
  function Person() {}
  
  Person.prototype.walk = function(){
    alert ('I am walking!');
  };
  Person.prototype.sayHello = function(){
    alert ('hello');
  };
  
  // define the Student class
  function Student() {
    // Call the parent constructor
    Person.call(this);
  }
  
  // inherit Person
  Student.prototype = new Person();
  
  // correct the constructor pointer because it points to Person
  Student.prototype.constructor = Student;
  
  // replace the sayHello method
  Student.prototype.sayHello = function(){
    alert('hi, I am a student');
  }
  
  // add sayGoodBye method
  Student.prototype.sayGoodBye = function(){
    alert('goodBye');
  }
  
  var student1 = new Student();
  student1.sayHello();
  student1.walk();
  student1.sayGoodBye();
  
  // check inheritance
  alert(student1 instanceof Person); // true
  alert(student1 instanceof Student); // true
  
  // Object.create 사용
  Student.prototype = Object.create(Person.prototype);
  ```





## 참고 페이지

- [객체지향 자바스크립트 개요](https://developer.mozilla.org/ko/docs/Web/JavaScript/Introduction_to_Object-Oriented_JavaScript#javascript_review)

