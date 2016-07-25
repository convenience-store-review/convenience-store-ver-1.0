package org.review.cvs.search.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.review.cvs.commons.domain.BoardVO;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Product;
import org.review.cvs.commons.domain.SearchCriteria;
import org.review.cvs.commons.domain.UserReview;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAOImpl implements SearchDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.review.cvs.mapper.SearchMapper";

	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Product> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public int collaboCountPaging(Criteria cri) throws Exception {

		return session.selectOne(namespace + ".collaCountPaging", cri);
	}

	@Override
	public List<CollaboReview> collaListSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".collaboSearch", cri);
	}

	@Override
	public int collaboListSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".collaListSearchCount", cri);
	}

	@Override
	public List<UserReview> userReviewListSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".userReviewSearch", cri);
	}

	@Override
	public int userReviewListSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne(namespace + ".userReviewListSearchCount", cri);
	}

}
