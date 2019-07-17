package my.spring.festival;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.detailDAO;
import vo.detailReviewVO;
import vo.detailVO;

@Controller
public class detailController {
	@Autowired
	 detailDAO dao;
	
	String fidd;
	@RequestMapping(value="/detail",method=RequestMethod.GET)
    public ModelAndView detailGet(detailVO vo, HttpSession session, String fid) {
		ModelAndView mav = new ModelAndView();
		String mid = (String)session.getAttribute("mid");
		fidd = fid;
		if(fid!=null) {
			mav.addObject("list", dao.listAll(Integer.parseInt(fid)));
			mav.addObject("img", dao.imgList(Integer.parseInt(fid)));
			mav.addObject("review", dao.reviewList(Integer.parseInt(fid)));
			mav.addObject("map", dao.festival(Integer.parseInt(fid)));
		}
        if(mid!=null) {
        	mav.addObject("exist","로그인");
        }else {
        	mav.addObject("!exist","로그인이 필요합니다.");
        }
        mav.setViewName("detail");
        return mav;
  }
	
	@RequestMapping(value="/detail",method=RequestMethod.POST)
    public ModelAndView detailPost(detailVO vo, detailReviewVO vo1, HttpSession session, String action) {
		ModelAndView mav = new ModelAndView();
		String mid = (String)session.getAttribute("mid");
		System.out.println(fidd);
		if(fidd!=null) {
			if(action.equals("insReview")) {
				System.out.println("form 수행 시작");
				vo1.setMid(mid);
				vo1.setFid(Integer.parseInt(fidd));
				if (dao.insertReview(vo1)) {
					System.out.println("insert 완료");
					mav.addObject("msg", "작성이 완료되었습니다.");
				}
				else {
					System.out.println("insert 실패");
					mav.addObject("msg", "리뷰 작성에 실패했습니다.");
				}
			}
			mav.addObject("list", dao.listAll(Integer.parseInt(fidd)));
			mav.addObject("img", dao.imgList(Integer.parseInt(fidd)));
			mav.addObject("review", dao.reviewList(Integer.parseInt(fidd)));
		}
        if(mid!=null) {
        	mav.addObject("exist","로그인");
        }else {
        	mav.addObject("!exist","로그인이 필요합니다.");
        }

		
        mav.setViewName("detail");
        return mav;
  }
	
}
