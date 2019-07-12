package my.spring.festival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MyPageDAO;
import vo.MyPageReviewVO;
import vo.MyPageVO;

@Controller
public class MyPageController {
	@Autowired
	 MyPageDAO dao;
		
	@RequestMapping(value="/MyPage", method=RequestMethod.GET)
	public ModelAndView get(MyPageVO vo, MyPageReviewVO vo1, String action) {
		
		vo.setMid("dj9308"); // 임시 아이디 입력
		
		ModelAndView mav = new ModelAndView();
					
		mav.addObject("info", dao.listOne(vo.getMid()));
		
		mav.addObject("list", dao.reviewList(vo1.getFid()));
		mav.setViewName("MyPage");
		return mav;
	}
	
	@RequestMapping(value="/MyPage", method=RequestMethod.POST)
	public ModelAndView post(MyPageVO vo, String action ,String oldpw,String pw1, String pw2
			,String phone, String email) {
		vo.setMid("dj9308"); // 임시 아이디 입력
		
		ModelAndView mav = new ModelAndView();
		vo=dao.listOne(vo.getMid());		
		mav.addObject("info", vo);		
		
			if(action!=null && action.equals("updatepw")) {	// 비밀번호 수정

				if(!oldpw.equals(vo.getPw())) {
					mav.addObject("msg", "입력한 기존 비밀번호가 다릅니다!");
				}else if(!pw2.equals(pw1)){
					mav.addObject("msg", "비밀번호를 다시 확인하시기 바랍니다.");
				}else {
					vo.setPw(pw1);
					if (dao.update(vo)) mav.addObject("msg", "비밀번호가 수정되었습니다.");
				}
			}else if(action!=null && action.equals("updatepm")) { // 이메일 및 휴대전화 수정
				vo.setEmail(email);
				vo.setPhone(phone);
				if(dao.updatepm(vo)) mav.addObject("msg", "정보가 수정되었습니다.");
			}
			mav.setViewName("MyPage");
			return mav;


	}
}

