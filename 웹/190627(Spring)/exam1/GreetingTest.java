package exam1;
import java.time.LocalDateTime;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("exam1/omg.xml");
		LocalDateTime bean=(LocalDateTime)factory.getBean("local");
				int time = bean.getHour();
				if(time>=6 && time<12) {
					MorningGreetingImpl bean1=(MorningGreetingImpl)factory.getBean("morn");
					System.out.println(bean1);
				}else if(time>=12 && time<17) {
					((AfternoonGreetingImpl)factory.getBean("after")).greet();
				}else if(time>=17 && time<22) {
					((EveningGreetingImpl)factory.getBean("even")).greet();
				}else {
					((NightGreetingImpl)factory.getBean("night")).greet();
				}
	}

}
