package com.qq.dao;



public interface DAO  {

	/**
	 * 方法名称: selectOne
	 * 所需参数: String sqlId ,Object obj
	 * 参数说明: sqlId 映射的sql主键
	 * 方法说明: 通过id获得实体类
	 */
	public Object selectOne(final String sqlId, Object obj);
	/**
	 * 方法名称: select
	 * 所需参数: Object sqlId ,Object obj
	 * 参数说明: sqlId 映射的sql主键
	 * 方法说明: 获得所有实体类
	 */
	public Object select(final String sqlId, Object obj);
	/**
	 * 方法名称: insert
	 * 所需参数: String sqlId ,Object obj
	 * 参数说明: sqlId 映射的sql主键 
	 * 方法说明: 插入数据
	 */
	public int insert(final String sqlId, Object obj);
	/**
	 * 方法名称: update
	 * 所需参数: String sqlId ,Object obj
	 * 参数说明: sqlId 映射的sql主键 
	 * 方法说明: 批量更新
	 */
	public int update(final String sqlId, Object obj);/**
	/**
	 * 方法名称: update
	 * 所需参数: String sqlId ,Object obj
	 * 参数说明: sqlId ：映射的sql主键 
	 * 方法说明: 批量删除
	 */
	public int delete(final String sqlId, Object obj);
	
	public void  getSession(String key);
	
}
