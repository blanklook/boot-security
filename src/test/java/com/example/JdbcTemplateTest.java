package com.example;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import javax.sql.DataSource;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JdbcTemplateTest extends BasicTest {
	
	@Autowired
	DataSource ds;

	@Test
	public void test1() {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ds);
		List<Member> members =
		jdbcTemplate.query("SELECT id, home_city FROM Members", super.mapper);
		assertThat(members.size(), is(200));
	}
	@Test
	public void test2() {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ds);
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", 200);
		Member m = jdbcTemplate.queryForObject("SELECT id, home_city FROM Members WHERE id = :id", paramSource, super.mapper);
		assertThat(m, is(notNullValue()));
	}

}
