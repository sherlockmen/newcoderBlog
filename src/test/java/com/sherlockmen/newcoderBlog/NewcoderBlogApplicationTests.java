package com.sherlockmen.newcoderBlog;

import com.sherlockmen.newcoderBlog.dao.AlphaDao;
import com.sherlockmen.newcoderBlog.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = NewcoderBlogApplication.class)
class NewcoderBlogApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	void contextLoads() {
		System.out.println(applicationContext);
		AlphaDao bean = applicationContext.getBean(AlphaDao.class);
		System.out.println(bean.select());
	}

	@Test
	public void testBeanManagement(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat bean = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(bean.format(new Date()));
	}

	@Autowired
	private AlphaDao alphaDao;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}
}
