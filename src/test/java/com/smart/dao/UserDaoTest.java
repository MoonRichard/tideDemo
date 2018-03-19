package com.smart.dao;

import com.smart.domain.User;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

import static org.junit.Assert.*;


public class UserDaoTest extends BaseDaoTest {

	@SpringBean("userDao")
	private UserDao userDao;


	@Test
	@DataSet("XiaoChun.Users.xls")//准备数据
	public void findUserByUserName() {
		User user = userDao.getUserByUserName("tony");
		assertNull("不存在用户名为tony的用户!", user);
		user = userDao.getUserByUserName("john");
		assertNotNull("John用户存在！", user);
		assertEquals("john", user.getUserName());
		assertEquals("123",user.getPassword());
		assertEquals(1, user.getUserType());
		assertEquals(0, user.getLocked());
		assertEquals("深圳", user.getUserLocation());
		assertEquals(1, user.getUserSex());
		assertEquals(10, user.getUserAge());
	}

	// 验证数据库保存的正确性
	@Test
	@DataSet(value = "XiaoChun.Users.xls")
	public void saveUser()throws Exception  {
		User user = new User();
		user.setUserId(4);
		user.setUserName("tim");
		user.setPassword("123");
		user.setUserType(1);
		user.setLocked(0);
		user.setUserLocation("sb");
		user.setUserSex(1);
		user.setUserAge(10);
		userDao.save(user);
		user = userDao.getUserByUserName("tim");
		assertNotNull("d", user);
	}
	






}
