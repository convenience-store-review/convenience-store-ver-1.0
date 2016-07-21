package org.cvs.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.review.cvs.collabo.persistence.CollaboBoardDAO;
import org.review.cvs.collabo.persistence.CollaboReplyDAO;
import org.review.cvs.commons.domain.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class collaboDAOTest {
	
	@Inject
	private CollaboReplyDAO dao2;
	//private CollaboBoardDAO dao;
	private Criteria cri;
	
	private static final Logger logger=LoggerFactory.getLogger(collaboDAOTest.class);
	
	@Test
	public void testList() throws Exception {
		logger.info(dao2.list(7).toString());
		
	}
}
