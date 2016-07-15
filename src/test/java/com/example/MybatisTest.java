package com.example;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.MemberMapper;
import com.example.domain.MemberStatistics;

public class MybatisTest extends BasicTest {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	MemberMapper mapper;

	@Test
	public void testTime1() {
		SqlSession session =
		sqlSessionFactory.openSession();
		String time = session.selectOne("com.example.domain.MemberMapper.getTime");
		assertThat(time, is(notNullValue()));
	}
	@Test
	public void testTime2() {
		String time = mapper.getTime();
		assertThat(time, is(notNullValue()));
	}
	@Test
	public void testFindAll1() {
		SqlSession session =
		sqlSessionFactory.openSession();
		List<com.example.domain.Member> members =
		session.selectList("com.example.domain.MemberMapper.findAll");
		assertThat(members.size(), is(200));
	}
	@Test
	public void testFindAll2() {
		List<com.example.domain.Member> members = mapper.findAll();
		assertThat(members.size(), is(200));
	}
	@Test
	public void testStatistics1() {
		SqlSession session =
		sqlSessionFactory.openSession();
		List<MemberStatistics> statistics =
		session.selectList("com.example.domain.MemberMapper.statistics");
		assertThat(statistics.size(), is(2));
	}
	@Test
	public void testStatistics2() {
		List<MemberStatistics> statistics = mapper.statistics();
		assertThat(statistics.size(), is(2));
	}
}
