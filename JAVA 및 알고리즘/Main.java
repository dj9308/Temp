package practice1;

// 구조를 파악하는게 제대로 되지 않아 시간 소요가 제일 많이 걸림
// 결국 인터넷을 이용해 구조를 파악한 후 구현.
// 하지만 처음 구현할 때는 거의 배끼다시피 구현해서 한줄 한줄 구현의 의미를 알고
// 순서를 이해한 후  4번 반복해서 구현해보니 이제야 구조가 어떻게 되는지 알았다. 



class LinkedNode {// LinekedList를 구성하는 node 클래스
	int val;
	LinkedNode next; //다음 node를 가르키기 위한 객체

	LinkedNode(int val) {
		next = null;
		this.val = val;
	}
}

class LinkedList {
	LinkedNode first; // LinekedList의 첫 node
	LinkedNode last; // LinekedList의 마지막 node
	
	LinkedList() {
		first = null;
		last = null;
	}

	protected void addFirst(int val) {
		LinkedNode fadd = new LinkedNode(val);
		fadd.next = first;	// 다음 노드에 first로 생성(한칸 미룸)
		first = fadd;		// 처음에 삽입
		if(first.next==null) {   // next 생성한게 비었을 시 = 처음부터 비었을 때
			last = first;  	// 노드가 존재해서 first와 last는 같아야함.
		}
	}

	protected void addLast(int val) {
		LinkedNode ladd = new LinkedNode(val);
		if(first==null) {
			addFirst(val);
			last = first; 
		}else {
			last.next = ladd; 
			last = ladd;
			
		}
	}

	protected Boolean removeFirst() {
		LinkedNode firmove = first;
		first = firmove.next;
		firmove = null;
		return true;
	}

	protected Boolean removeLast() {
		return false;
	}

	protected void printList() {
		LinkedNode current = first;
		while (current != null) { //current 노드가 null 아닐때 까지 실행
			System.out.println(current.val);
			current = current.next; //next 노드를 current에 덮어 씌움
		}
	}
}

class Queue extends LinkedList {
	Queue() {
		super();
	}

	public void add(int val) {
		super.addLast(val);
	}

	public void remove() {
		System.out.println("삭제 결과 : " + super.removeFirst());
	}

	public void printList() {
		System.out.println("----------queue print----------");
		super.printList();
		System.out.println("------------------------------");
	}
}



class Stack extends LinkedList{
	Stack(){
		 super(); //LinkedList의 생성자를 실행
	}
	
	public void add(int val) {
		super.addFirst(val);
	}
	
	public void remove() {
		System.out.println("삭제 결과 : " + super.removeFirst());
	}
	
	public void printList() {
		System.out.println("----------stack print----------");
		super.printList();
		System.out.println("------------------------------");
	}
}


public class Main {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.printList();
		s.remove();
		s.remove();
		s.remove();
		s.printList();
		
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.printList();
		q.remove();
		q.remove();
		q.printList();
	}
}
/*
	-----------설명--------------
	지난번에 배운 stack, queue에 대한 구현
		1. 언어 : 자바
		2. 사용한 자료구조 : 연결리스트
	
	첨부한 클래스다이어그램 사진과 소스코드에 첨부한 주석을 참고하면 이해가 됨
	
	이 코드를 다 읽고 이해가 된다면 마스터하는 개념!
		1. 자료구조의 연결리스트
		2. 자바의 접근권한자
		3. 자바의 클래스의 상속
		4. 스택과 큐
	----------------------------
*/