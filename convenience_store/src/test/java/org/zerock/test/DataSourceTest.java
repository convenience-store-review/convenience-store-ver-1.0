package org.zerock.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.persistence.UserReivewDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class DataSourceTest {

  @Inject
  private UserReivewDAO dao;

  private static Logger logger = LoggerFactory.getLogger(DataSourceTest.class);

 
  @Test
  public void testRead() throws Exception {

    logger.info(dao.read(1).toString());
  }


}
