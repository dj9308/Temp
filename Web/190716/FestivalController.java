package my.spring.festival;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.FestivalDAO;
import vo.FestivalList;
import vo.FestivalVO;
import vo.SearchInfoVO;
@Controller
public class FestivalController {

	@Autowired
	FestivalDAO dao;
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
    public ModelAndView mainView(String action) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Controller.loginView() 호출");
		
		if(action==null){
			System.out.println("action != null 걸림");
			//List<FestivalVO> list = dao.listAll();
			//mav.addObject("list", list);
		}
        mav.setViewName("festivalMain");
        return mav;
  }

	
	//festivalSelect
		@RequestMapping(value = "/select", method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView select(String fid) {
			ModelAndView mav = new ModelAndView();
			System.out.println("이미지 select 들어옴");

			FestivalVO vo = dao.festivalSelect(fid);
			System.out.println(vo);
			mav.setViewName("detail");
			return mav;

		}
		
		int size = 10;
		@ModelAttribute("festainfo")
		public SearchInfoVO createFestainfo() {
			return new SearchInfoVO();
		}
		
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView showList(@ModelAttribute("festainfo") SearchInfoVO festainfo, SearchInfoVO info, int pageNo) {
			System.out.println("여기왔음");
			List<FestivalVO> tmplist;
			
			ModelAndView mav = new ModelAndView();	
			if(info.getAction().equals("search"));
				festainfo = info;
				System.out.println("festainfo출력" + info.toString());
			int total = dao.selectCount(festainfo);
			festainfo.setStartRow((pageNo-1)*size);
			festainfo.setSize(size);
			tmplist = dao.search(festainfo);
			
			if (tmplist.size() == 0) {
				mav.addObject("listMsg", "검색하신 정보에 해당하는 축제가 존재하지 않습니다.");
			}else {
				mav.addObject("resultlist", new FestivalList(total, pageNo, size, tmplist));
			}
			
			
			int size =  tmplist.size();
			Float[][] latlng = new Float[size][3];
			String[] name = new String[size];
			FestivalVO festa;
			for(int i =0;i<size;i++) {
				festa = tmplist.get(i);
				System.out.println("festa 값"+festa);
				latlng[i][0]= festa.getLat();
				latlng[i][1]= festa.getLng();
				latlng[i][2]= (float)festa.getFid();
				System.out.println("lat lng fid 순으로 출력"+latlng[i][i]);
				name[i] = festa.getName();
				System.out.println(name[i]);
			}
			mav.addObject("latlng", tmplist);
			mav.setViewName("showlist");
			return mav;
		}
}
