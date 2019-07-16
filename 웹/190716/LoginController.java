package my.spring.festival;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.FestivalDAO;
import vo.FestivalVO;
import vo.MemberinfoVO;

@Controller
public class LoginController {
	@Autowired
	FestivalDAO dao;

	//로그인 입력페이지
	@RequestMapping("/loginmain")
	@ResponseBody
	public ModelAndView loginmain() {
		ModelAndView mav = new ModelAndView();
		System.out.println("loginmain 호출 ");
		mav.setViewName("login");
		return mav;
	}

	//로그인 처리 페이지
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public boolean login(String mid, String pw, HttpSession session) {
		MemberinfoVO vo = dao.checklogin(mid, pw);
		System.out.println("login 화면 호출");
		if (vo != null) {
			session.setAttribute("mid", vo.getMid());
			return true;
		}
		return false;
	}
	
	//로그인 성공시 아이디,이메일 세션값 받아옴
	@RequestMapping(value = "/success")
	public ModelAndView mainpage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("festivalMain");
		return mav;
	}
	
	//로그아웃 
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("festivalMain");
		return mav;
	}

}