package com.zengzhx.dp.constant;

import com.zengzhx.dp.model.User;

public class UserConstant {
	
	public static User getUser() {
		User zhangsan = new User();
		zhangsan.setName("zhangsan");
		zhangsan.setPwd("123456");
		return zhangsan;
	}
}
