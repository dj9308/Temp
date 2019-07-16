package my.spring.festival;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.detailDAO;
import vo.detailVO;

@Controller
public class detailController {
	@Autowired
	 detailDAO dao;
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
    public ModelAndView memberView(detailVO vo, HttpSession session, String fid) {
		ModelAndView mav = new ModelAndView();
		if(fid!=null) {
			mav.addObject("list", dao.listAll(Integer.parseInt(fid)));
		}
        mav.setViewName("detail");
        return mav;
  }
	
}
