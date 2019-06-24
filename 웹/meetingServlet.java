package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.MeetingJDBCDAO;
import model.dao.VisitorDAO;
import model.vo.MeetingVO;
import model.vo.VisitorVO;
@WebServlet("/meeting")
public class meetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   protected void doGet(HttpServletRequest request, 
		         HttpServletResponse response) 
		               throws ServletException, IOException {
		      String keyword = request.getParameter("keyword");
		      String id = request.getParameter("id");
		      //DB연동은 VisitorDAO 에서!
		      MeetingJDBCDAO dao = new MeetingJDBCDAO();
		      
		      if(id!=null) {
		         boolean result = dao.delete(Integer.parseInt(id));
		         
		         if(result) {
		            request.setAttribute("msg", "글이 삭제됨!");
		         }else {
		            request.setAttribute("msg", "글 삭제 실패;");
		         }
		      }
		      
		      else if(keyword == null) {   
		         request.setAttribute("list", dao.listAll());
		      }else {
		         List<MeetingVO> list = dao.search(keyword);
		         //해당 keyword를 가지고 있는 검색어가 db에 하나도 없을떄 
		         if(list.size() == 0) {
		            request.setAttribute("msg", keyword+"를 담고있는게 없음");
		         }else {
		            request.setAttribute("list",list);
		         }      
		      }
		      String url="/jspexam/meetingView.jsp";
		      request.getRequestDispatcher(url).
		      forward(request, response);
		   }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      request.setCharacterEncoding("UTF-8");      

	      String name = request.getParameter("name");
	      String memo = request.getParameter("content");
	      String date = request.getParameter("date");
	      
	      MeetingJDBCDAO dao = new MeetingJDBCDAO();
	      MeetingVO vo = new MeetingVO();
	      
	      vo.setName(name);
	      vo.setPerpose(memo);
	      vo.setDate(date);
	      
	      boolean result = dao.insert(vo);
	      
	      if(result) {
	          request.setAttribute("msg", name+"님의 글이 성공적으로 입력됨 -ㅅ-!");
	       }else {
	          request.setAttribute("msg", name+"님의 글이 입력 실패 =ㅅ=...");
	       }
	       
	       String url="/jspexam/meetingView.jsp";
	       request.getRequestDispatcher(url).
	          forward(request, response);
	      }

}
