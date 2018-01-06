package com.zking.bookstore.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml", "classpath*:spring/spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class BaseTestCase {

    @Before
    public void setUp() throws Exception {

    }
}
