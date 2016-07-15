package com.example;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class AppTest {

	@Autowired
	ConfigurableApplicationContext context;
	@Autowired
	DataSource ds;
	
	RowMapper<Member> mapper = (rs, rowNum) -> new Member(rs.getInt("id"), rs.getString("home_city"));

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
	class Member {
		int id;
		String home_city;
		public Member(int id, String home_city) {
			this.id = id;
			this.home_city = home_city;
		}
		@Override
		public String toString() {
			return "Member [id=" + id + ", home_city=" + home_city + "]";
		}
	}
}
