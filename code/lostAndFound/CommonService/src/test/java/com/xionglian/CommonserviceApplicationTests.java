package com.xionglian;

import com.google.gson.Gson;
import com.xionglian.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonserviceApplicationTests {

	@Test
	public void contextLoads() {
		Gson gson = new Gson();
		String str = "{\"id1\":0,\"userName2\":\"xionglian\"}";
		User u = gson.fromJson(str,User.class);
		System.out.println(u.getId());
	}

}
