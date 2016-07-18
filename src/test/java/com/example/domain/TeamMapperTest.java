package com.example.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.App;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@Transactional
public class TeamMapperTest {

	@Autowired
	TeamMapper mapper;
	@Test
	public void test() {
		assertThat(mapper, is(notNullValue()));
	}
	@Test
	public void testFindAll() {
		int size = mapper.findAll().size();
		assertThat(size > 0, is(true));
	}
	@Test
	public void testInsert() {
		mapper.insert(new Team("TEAM C"));
		int size = mapper.findAll().size();
		assertThat(size, is(3));
	}
	@Test
	public void testFindByName() {
		Team t = mapper.findByName("TEAM A");
		assertThat(t, is(notNullValue()));
		assertThat(t.getMembers().size(), is(100));
		t.getMembers().forEach(System.out::println);
	}
}
