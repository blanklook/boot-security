package com.example.domain;

import static org.junit.Assert.*;

import java.util.Date;

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
public class MemberMapperTest {
	@Autowired
	MemberMapper mapper;
	@Test
	public void test() {
		assertThat(mapper, is(notNullValue()));
	}
	@Test
	public void testFindAll() {
		int size = mapper.findAll().size();
		assertThat(size, is(200));
	}
	@Test
	public void testfindById() {
		Team t = mapper.findById(1).getTeam();
		assertThat(t, is(notNullValue()));
	}
	@Test
	public void testInsert() {
		mapper.insert(new Member("city","street","zipcode","name",new Date(), new Date(), 1));
	}
	@Test
	public void testDeleteById() {
		int size = mapper.findAll().size();
		assertThat(size, is(200));
		Member m = mapper.findById(1);
		mapper.deleteById(m);
		size = mapper.findAll().size();
		assertThat(size, is(199));
	}
}
