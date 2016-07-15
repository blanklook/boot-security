package com.example;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class AppTest {

	@Autowired
	ConfigurableApplicationContext context;

	@Test
	public void test() {
		assertThat(context, is(notNullValue()));
		FilterRegistrationBean registrationBean = context.getBean("delegatingFilterProxy", FilterRegistrationBean.class);
		assertThat(registrationBean, is(notNullValue()));
	}
}
