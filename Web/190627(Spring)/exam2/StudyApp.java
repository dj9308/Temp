package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("exam2/omg.xml");
		
		Student bean1 = (Student)factory.getBean("st1");
		Student bean2 = (Student)factory.getBean("st2");
		Student bean3 = (Student)factory.getBean("st3");
		
		System.out.println(bean1.getName()+"는 "+bean1.getMyHomework().getHomeworkName()
				+"를 학습합니다.");
		System.out.println(bean2.getName()+"는 "+bean2.getMyHomework().getHomeworkName()
				+"를 학습합니다.");
		System.out.println(bean3.getName()+"는 "+bean3.getMyHomework().getHomeworkName()
				+"을 학습합니다.");
		
	}

}
