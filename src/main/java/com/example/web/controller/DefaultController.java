package com.example.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	List<Member> members;
	
	public DefaultController() {
		this.members = IntStream.rangeClosed(25, 55)
		.mapToObj(n -> new Member("Name "+n, n))
		.collect(Collectors.toList());
	}
	
	@RequestMapping("/members")
	public List<Member> members() {
		return this.members;
	}
	
	class Member {
		String name;
		Integer age;
		public Member(String name, Integer age) {
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public Integer getAge() {
			return age;
		}
	}
}
