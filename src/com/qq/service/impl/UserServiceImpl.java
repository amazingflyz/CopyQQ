package com.qq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qq.dao.BaseDAO;
import com.qq.model.Message;
import com.qq.model.User;
import com.qq.service.UserService;
import com.qq.util.JsonMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public BaseDAO bDao;
	String bankjson = "";
	JsonMapper jm = new JsonMapper();
	Message message = new Message();
	public String login(String str) {
		List<Object> list = new ArrayList<Object>();
		User  user = jm.fromJson(str, User.class);
		list= bDao.select("login", user);
		if(list.size()>0){
			message.setCode("-1");
			message.setMsg("登录成功");
			System.out.println(jm.toJson(list));
			message.setData(jm.toJson(list));
			bankjson = jm.toJson(message);
			return bankjson;
		}else{
			return "登录失败！";
		}
	}
//登录成功[{"code":"0","msg":"登录成功","data":"[{"oo":"61700497","pwd":"123456","nicheng":"XXOO",.....}]"}]
//	登录失败[{"code":"-1","msg":"登录失败","data":"null"}]
	public String register(String str) {
		return null;
	}

}
