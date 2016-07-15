package com.example;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppTest extends BasicTest {

	@Autowired
	ConfigurableApplicationContext context;
	@Autowired
	DataSource ds;
	

	@Test
	public void test1() {
		assertThat(context, is(notNullValue()));
		assertThat(ds, is(notNullValue()));
	}
	@Test
	public void test2() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		List<Member> members =
				jdbcTemplate.query("SELECT id, home_city FROM MEMBERS", mapper);
		assertThat(members.size(), is(200));
	}
	@Test
	public void test3() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		Member m =
		jdbcTemplate.queryForObject("SELECT id, home_city FROM MEMBERS WHERE id=1", mapper);
		assertThat(m, is(notNullValue()));
	}
}
