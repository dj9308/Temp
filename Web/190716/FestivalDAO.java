package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.FestivalVO;
import vo.MemberinfoVO;
import vo.SearchInfoVO;

@Repository
public class FestivalDAO {
	@Autowired
	SqlSession session = null;
	
	public boolean insert(MemberinfoVO vo) {
		boolean result=true;
		System.out.println(vo);
		System.out.println("insert 에걸림");
		String statement = "resource.MemberMapper.insertMember";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	
	public boolean checkId(String mid) {
		System.out.println("DAO넘어온값 " + mid);
		String statement = "resource.MemberMapper.checkId";
		if (session.selectOne(statement, mid) != null) {
			System.out.println("return TRUE쪽");
			return true;
		}
		System.out.println("return false걸림");
		return false;
	}	
	
	public MemberinfoVO checklogin(String mid, String pw) {
		String statement= "resource.MemberMapper.login";
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("mid", mid);
		map.put("pw", pw);
		System.out.println("checkLogin map객체 : "+map);
		MemberinfoVO vo = session.selectOne(statement,map);
		if(session.selectOne(statement,map) != null) return vo;
		return null;
	}	
	
	public FestivalVO festivalSelect(String fid) {
		String statement= "resource.MemberMapper.festivalSelect";
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("fid", fid);
		System.out.println("FestivalVO map객체 : "+map);
		FestivalVO vo = session.selectOne(statement,map);
		if(session.selectOne(statement,map) != null) return vo;
		return null;
	}
	
	public List<FestivalVO> search(SearchInfoVO info){
		List<FestivalVO> list;
		System.out.println("searchDAO 걸림");
		String statement = "resource.FestivalMapper.selectFestival";
		list = session.selectList(statement, info);
		return list;
	}
	public int selectCount(SearchInfoVO info) {
		System.out.println("selectCountDAO 걸림");
		String statement = "resource.FestivalMapper.selectFestivalCount";
		return session.selectOne(statement, info);
	}
}




