package my.spring.festival;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MyPageDAO;
import vo.MyPageBasketVO;
import vo.MyPageReviewVO;
import vo.MyPageVO;

@Controller
public class MyPageController {
	@Autowired
	 MyPageDAO dao;

	@RequestMapping(value="/MyPage", method=RequestMethod.GET)
	public ModelAndView get(MyPageVO vo, MyPageReviewVO vo1, MyPageBasketVO vo2,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("mid")==null) {
			mav.addObject("msg","만료된 페이지입니다.");
			mav.setViewName("login");
		}
		String mid = (String)session.getAttribute("mid");

		vo.setMid(mid);		
		vo1.setMid(mid);
		vo2.setMid(mid);
		
		
		mav.addObject("list", dao.reviewList(vo1));
		mav.addObject("info", dao.listOne(vo.getMid()));
		mav.addObject("basket", dao.basket(vo2));


		
		mav.setViewName("MyPage");

		return mav;
	}
	
	@RequestMapping(value="/MyPage", method=RequestMethod.POST)
	public ModelAndView post(MyPageVO vo, MyPageReviewVO vo1, MyPageBasketVO vo2,
			String action ,String oldpw,String pw1, String pw2
			,String phone, String email,String pw_1,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("mid")==null) {
			mav.addObject("msg","만료된 페이지입니다.");
			mav.setViewName("login");
		}
		
		String mid = (String)session.getAttribute("mid");
		
		vo.setMid(mid);		
		vo1.setMid(mid);
		vo2.setMid(mid);
		
		mav.addObject("list", dao.reviewList(vo1));
		mav.addObject("basket", dao.basket(vo2));
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
			System.out.println(dao.pw(mid).getPw());
			if(pw_1!=null && !pw_1.equals(dao.pw(mid).getPw())) {
				mav.addObject("pwmsg", "비밀번호가 다릅니다.");
			}else if(pw_1!=null && pw_1=="") {
				mav.addObject("pwmsg", "비밀번호를 입력하십시오.");
			}else {
				mav.addObject("enterMsg", "ㅎㅇㅎㅇ");
			}
			mav.setViewName("MyPage");
			return mav;


	}
}

