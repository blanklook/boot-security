package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.RowMapper;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public abstract class BasicTest {

	RowMapper<Member> mapper = (rs, rowNum) -> new Member(rs.getInt("id"), rs.getString("home_city"));

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
