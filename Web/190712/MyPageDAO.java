package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MyPageReviewVO;
import vo.MyPageVO;

@Repository
public class MyPageDAO {
	@Autowired
	SqlSession session = null;
	
	public MyPageVO listOne(String mid) {
		MyPageVO vo = null;
		String statement = "resource.MyPageMapper.info";
		vo = session.selectOne(statement, mid);
		return vo;
	}
	public boolean update(MyPageVO vo) {
		String statement = "resource.MyPageMapper.update";
		if (session.update(statement, vo) != 1) return false;
		return true;
	}
	public boolean updatepm(MyPageVO vo) {
		String statement = "resource.MyPageMapper.updatepm";
		if (session.update(statement, vo) != 1) return false;
		return true;
	}
	
	public List<MyPageReviewVO> reviewList(int fid){
		List<MyPageReviewVO> list = null;
		MyPageReviewVO vo = new MyPageReviewVO();
		vo.setFid(fid);
		String statement = "resource.MyPageMapper.reviewInfo";
		list = session.selectList(statement, fid);
		return list;
	}
}
