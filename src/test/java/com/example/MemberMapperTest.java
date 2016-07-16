package com.example;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.MemberMapper;

public class MemberMapperTest extends BasicTest {

	@Autowired
	MemberMapper mapper;
	
	@Test
	public void test() {
		assertThat(mapper, is(notNullValue()));
		com.example.domain.Member m = mapper.findOne(1);
		assertThat(m, is(notNullValue()));
	}

}
