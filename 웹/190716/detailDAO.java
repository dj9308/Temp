package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.detailVO;

@Repository
public class detailDAO {
	@Autowired
	SqlSession session = null;
	
	public List<detailVO> listAll(int fid){
		List<detailVO> list = null;
		String statement = "resource.detailMapper.selectAll";
		list = session.selectList(statement, fid);
		return list;
	}
}
