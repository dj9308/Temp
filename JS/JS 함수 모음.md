# JS 함수 모음

- setInterval(함수이름, 시간(milisecond))  : 시간에 맞춰 함수 실행

  - ```javascript
    getTime();   // 함수를 실행한다고 선언해야 setInterval이 돌아감.
    setInterval(getTime,1000);	// 이름만 참조하는 것이기 때문에, ()는 붙이지 않음
    ```

- 변수.classList.add(remove) : 클래스 값 추가 제거

- localStorage.setItem(key, value); 로컬 스토리지에 정보 넣기

- localStorage.getItem(key) : 로컬 스토리지에 있는 정보 가져오기

- foreach(function()){} : 객체의 값마다 각각 function을 수행하는 함수

  - ```javascript
    function loadToDos(){
        const loadedToDos= localStorage.getItem(TODO_LS);
        if(loadedToDos!==null){
         const parsedToDos = JSON.parse(loadedToDos); //객체(json).foreach
         parsedToDos.forEach(function(toDo){ //안쪽 function의 파라미터는 객체 자신을 뜻함.
             paintToDo(toDo.text); 
         })   
        }
    }
    ```

- console.log(event.target); : target으로 이벤트가 어디서 실행됐는지 알 수 있음.

- console.dir(event.target); : dir함수로 event.target의 무슨 함수를 쓸 수 있는지 알 수 있음.

  - ```javascript
    console.dir(event.target);  //로 함수 찾고
    console.log(event.target.parentNode); //적용(자동완성이 없을 수 있으니 dir쓰는게 좋을듯)
    ```

- flter(function)

  - ```javascript
    function deleteToDo(event){
        const btn= event.target;
        const li = btn.parentNode;
        toDoLIst.removeChild(li);
        const cleanToDos = toDos.filter(function(toDo){
            return toDo.id !== parseInt(li.id);
        });
        //filter: array의 모든 아이템을 통해 함수를 실행함
        //filter의 파라미터는 함수로, true인 것만 return해서 array를 채움
        toDos = cleanToDos;
        saveToDos();
    }
    ```

- 

### 기타

- js 함수 검색시, MDN이 좋은 참고 문서가 될 수 있다.