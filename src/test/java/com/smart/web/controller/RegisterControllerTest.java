package com.smart.web.controller;

import com.smart.cons.CommonConstant;
import com.smart.domain.User;
import com.smart.web.RegisterController;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class RegisterControllerTest extends BaseWebTest {
	@SpringBeanByType
	private RegisterController controller;

	@Test
	public void register() throws Exception {
		request.setRequestURI("/register.html");
		request.setMethod("POST");
		User user = new User();
		user.setUserName("adam");
		user.setPassword("1234");
		user.setUserLocation("LA");
		user.setLocked(0);

		// 向控制发起请求 
		ModelAndView mav = controller.register(request,user);
		User userBack = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		assertEquals(userBack.getUserName(), "adam");// ⑧ 验证返回结果
		assertEquals(userBack.getUserLocation(), "LA");
		assertNotNull(mav);
	}
	

}
