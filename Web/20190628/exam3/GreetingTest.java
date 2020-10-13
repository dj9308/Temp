package exam3;
import java.time.LocalDateTime;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GreetingTest {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("exam3/omg.xml");
		LocalDateTime bean=(LocalDateTime)factory.getBean("local");
		MorningGreetingImpl morn = factory.getBean("morn", MorningGreetingImpl.class);
				int time = bean.getHour();
				if(time>=6 && time<12) {
					morn.greet();
				}else if(time>=12 && time<17) {
					factory.getBean("after", AfternoonGreetingImpl.class).greet();
				}else if(time>=17 && time<22) {
					factory.getBean("even", EveningGreetingImpl.class).greet();
				}else {
					factory.getBean("night", NightGreetingImpl.class).greet();
				}
	}
}
