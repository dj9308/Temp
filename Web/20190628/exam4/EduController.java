package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public  class EduController {
	@RequestMapping("/EduController")
	public ModelAndView proc(String name ,int score) {
		ModelAndView mav = new ModelAndView();
	mav.addObject("name", name);
		if (score >= 90) {
			mav.setViewName("gradeA");
		} else if (score >= 80 && score <= 89) {
			mav.setViewName("gradeB");
		} else if (score >= 70) {
			mav.setViewName("gradeC");
		} else {
			mav.setViewName("gradeD");
		}
		return mav;
	}	
}




