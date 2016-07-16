package com.example;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;

import org.apache.ibatis.session.SqlSessionFactory;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.domain.TeamMapper;

@Transactional
public class TeamMapperTest extends BasicTest {
	
	@Autowired
	SqlSessionFactory factory;
	@Autowired
	TeamMapper mapper;

	@Test
	public void testFindAll1() {
		int size = factory.openSession().selectList("com.example.domain.TeamMapper.findAll").size();
		assertThat(size, is(2));
	}
	@Test
	public void testFindAll2() {
		int size = mapper.findAll().size();
		assertThat(size, is(2));
	}
	@Test
	public void testFindById() {
		Team t = mapper.findById(1);
		assertThat(t, is(notNullValue()));
		assertThat(t.getName(),is("TEAM A"));
	}
	@Test
	public void testInsert() {
		IntStream.rangeClosed(101, 200)
		.forEach(n -> mapper.insert(new Team("TEAM "+n)));
		int size = mapper.findAll().size();
		assertThat(size, is(102));
	}
	@Test
	public void testDeleteByName() {
		mapper.insert(new Team("TEAM C"));
		int size = mapper.findAll().size();
		assertThat(size, is(3));
		mapper.deleteByName("TEAM C");
		size = mapper.findAll().size();
		assertThat(size, is(2));
	}
	@Test
	public void testDelete() {
		mapper.insert(new Team("TEAM Z"));
		int size = mapper.findAll().size();
		assertThat(size, is(3));
		Team t = mapper.findByName("TEAM Z");
		mapper.delete(t.getId());
		size = mapper.findAll().size();
		assertThat(size, is(2));
	}
	@Test
	public void testFindOne() {
		Team t = mapper.findOne(1);
		assertThat(t, is(notNullValue()));
		t.getMembers().forEach(System.out::println);
	}
}
