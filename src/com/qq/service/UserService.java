package com.qq.service;

import com.qq.adapter.CopyQQ;

public interface UserService extends CopyQQ{
	public String login(String str);
	public String register(String str);

}
