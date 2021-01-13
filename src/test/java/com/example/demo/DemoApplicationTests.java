package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.controllers.*;

@SpringBootTest


class DemoApplicationTests {
    private BlogSpiderController Blogsc = new BlogSpiderController();
	@Test
	void contextLoads() throws Exception {
		  Blogsc.Run();
	}

}




