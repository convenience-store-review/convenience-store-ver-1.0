package org.review.cvs.collabo.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.review.cvs.commons.domain.BoardVO;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

//여기에서 만드는 mapper와 연결시켜 쿼리를 실행.
// .create  .read 이런것들이 mapper파일에서 id  
@Repository
public class CollaboBoardDAOImpl implements CollaboBoardDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace="org.review.cvs.mapper.CollaboMapper";
	
	@Override
	public CollaboReview collaboRead(Integer id) throws Exception {
		return session.selectOne(namespace+".collaboread",id);
	}
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read",bno);
	}
	
	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update",vo);
	}
	
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete", bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if(page <= 0) {
			page =1;
		}
		page = (page-1) * 10;
		
		return session.selectList(namespace+".listPage", page);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception{
		return session.selectList(namespace+".listCriteria", cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging", cri);
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}
	
}
