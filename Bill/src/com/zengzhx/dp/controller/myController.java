package com.zengzhx.dp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zengzhx.dp.model.User;

@Controller //控制类
public class myController {
	
	@Autowired  //自动装配
	private  HttpServletRequest request; //获取request请求对象的方式
	
//	@RequestMapping("/hello") 
	@RequestMapping(value="/hello",method=RequestMethod.POST) //method 设置只允许请求类型   
	@ResponseBody //如果不加则返回 ''.jsp 页面 ，添加则可以返回 任意类型数据
	public String getHello(@RequestBody String body) {
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		System.out.println(body);
		JSONObject object =  JSON.parseObject(body);
		System.out.println(object.get("1122"));
		JSONObject json=new JSONObject();
		json.put("aaaa", "bbbbb");
		json.put("abaaa", 11111);
		return json.toJSONString();
	}
	

}
