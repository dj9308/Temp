package day8;

public class PolyTest {

	public static void main(String[] args) {
		printObjectInfo(new Object());  
		printObjectInfo(new String("가나다")); 
		printObjectInfo("ABC"); 
		printObjectInfo(new java.io.File("c:\\")); 
		printObjectInfo(new java.util.Date()); 
		printObjectInfo(new int[10]); 
		printObjectInfo(new double[5][3]);
	}
	static void printObjectInfo(Object o) {// java.lang이 기본이라 object 앞에 안붙여도 됨.
		//정식이름: java.lang.Object
		if(o instanceof String) { //o 에 전달된 객체가 스트링객체인가?
		System.out.println("String객체가 전달됨!"+
		o.toString()+"("+((String)o).length()+")");
		// 어떤 자손이 추가 됐는지 모름 => 부모시점에서 접근 못함. => object>String이라서.
		// 부모에서 온 o 이니 String으로 형변환이 먼저 이루어져야함.
		}else {
			System.out.println("전달된 객체의 클래스명 : "+o.getClass().getName());
		}
		// object는 모든 유형이 가능 (자손 객체도 참조 가능) => object는 모두의 부모
		// 오브젝트 객체의 getclass 호출 및 getName 리턴  
		
	}
}
