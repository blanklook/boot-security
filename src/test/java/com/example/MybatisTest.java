package com.example;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.MemberStatistics;

public class MybatisTest extends BasicTest {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test1() {
		SqlSession session =
		sqlSessionFactory.openSession();
		String time = session.selectOne("com.example.mapper.Member.getTime");
		assertThat(time, is(notNullValue()));
	}
	@Test
	public void test2() {
		SqlSession session =
		sqlSessionFactory.openSession();
		List<com.example.domain.Member> members =
		session.selectList("com.example.mapper.Member.findAll");
		assertThat(members.size(), is(200));
	}
	@Test
	public void test3() {
		SqlSession session =
		sqlSessionFactory.openSession();
		List<MemberStatistics> statistics =
		session.selectList("com.example.mapper.Member.statistics");
		assertThat(statistics.size(), is(2));
	}
}
