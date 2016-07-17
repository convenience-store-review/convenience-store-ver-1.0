package org.review.cvs.collabo.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.review.cvs.commons.domain.AttachPhoto;
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
	public List<AttachPhoto> attachPhoto(Integer id) throws Exception {
		return session.selectList(namespace+".collabophoto",id);
	}
		
}
