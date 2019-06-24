package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.MeetingVO;
import model.vo.VisitorVO;

public class MeetingJDBCDAO implements MeetingDAO{

	@Override
	public List<MeetingVO> listAll() {
		List<MeetingVO> list = new ArrayList<>();
	      try {
	         Class.forName("oracle.jdbc.OracleDriver");
	      } catch(Exception e) {
	         System.out.println(e.getMessage());
	      }
	      try (Connection conn = DriverManager.getConnection
	            ("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery
	            ("select id, name, title, to_char(meetingdate, 'YYYY-MM-DD\"T\"HH24:MI') from meeting");) {
	         MeetingVO vo;
	         while(rs.next()) {
	           //첫번째 열
	            vo = new MeetingVO();
	            vo.setId(rs.getInt(1));
	            vo.setName(rs.getString(2));
	            vo.setPerpose(rs.getString(3));
	            vo.setDate(rs.getString(4));
	            list.add(vo);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	}

	@Override
	public boolean insert(MeetingVO vo) {
		  boolean result = true;
	      try {
	         Class.forName("oracle.jdbc.OracleDriver");
	      } catch(Exception e) {
	         System.out.println(e.getMessage());
	      }
	      try (Connection conn = DriverManager.getConnection
	            ("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
	            PreparedStatement pstmt = conn.prepareStatement(
	                  "insert into meeting values(meeting_seq.nextval, ?,  ?, TO_DATE( ? ,'YYYY-MM-DD\"T\"HH24:MI'))");) {
	    	  
	        pstmt.setString(1, vo.getName());
	         pstmt.setString(2,  vo.getPerpose());
	         pstmt.setString(3,  vo.getDate());
	         pstmt.executeUpdate(); 
	         
	      } catch (SQLException e) {
	         result = false;
	         e.printStackTrace();
	      }
	      return result;
	}

	@Override
	public List<MeetingVO> search(String keyword) {
		List<MeetingVO> list = new ArrayList<>();
	      try {
	         Class.forName("oracle.jdbc.OracleDriver");
	      } catch(Exception e) {
	         System.out.println(e.getMessage());
	      }
	      try (Connection conn = DriverManager.getConnection
	            ("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery
	            ("select id, name, title, to_char(meetingdate, 'YYYY-MM-DD\"T\"HH24:MI') "
	                  +"from meeting where name like '%"+keyword+"%'");) {
	         MeetingVO vo;
	         while(rs.next()) {
	           //첫번째 열
	            vo = new MeetingVO();
	            vo.setId(rs.getInt(1));
	            vo.setName(rs.getString(2));
	            vo.setPerpose(rs.getString(3));
	            vo.setDate(rs.getString(4));
	            list.add(vo);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	}

	@Override
	public boolean delete(int eNo) {
		 boolean result = true;
         try {
            Class.forName("oracle.jdbc.OracleDriver");
         } catch(Exception e) {
            System.out.println(e.getMessage());
         }
         try (Connection conn = DriverManager.getConnection
               ("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
               PreparedStatement pstmt = conn.prepareStatement(
                     "delete from meeting where id= ?");) {
            pstmt.setInt(1,eNo);
           int deleteNum =  pstmt.executeUpdate();
           if(deleteNum !=1)
              result = false;
           
           //try내에서 정상적으로 수행됬으면된거고
         } catch (SQLException e) {
            result = false;
            e.printStackTrace();
         }
         return result;
	}
	
}
