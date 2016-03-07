package com.qq.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("dao")
public class BaseDAO implements DAO {

	protected  static Logger log = Logger.getLogger(DAO.class.getName());
	@Autowired
	public SqlSession sqlSession;
	public Map<String,SqlSession> sessionMap=new HashMap<String, SqlSession>();
	
	public Map<String, SqlSession> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, SqlSession> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Object selectOne(final String sqlId, Object id) {
		log.debug("getting GenStudentinfo user with id :");
		try {
			Object obj = (Object) sqlSession.selectOne(sqlId, id);
			log.debug("getting by id successful");
			return obj;
		} catch (RuntimeException re) {
			log.error("getting by example failed", re);
			throw re;
		}
	}

	public List<Object> select(final String sqlId, Object obj) {
		log.debug("get User List by maping");
		try {
			List<Object> list = (List<Object>) sqlSession.selectList(sqlId, obj);
			log.debug("getting User by all successful, result size: "+ list.size());
			return list;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public int insert(final String sqlId, Object obj) {
		log.debug("insert User user");
		try {
			int insert = sqlSession.insert(sqlId, obj);
			log.debug("save successful");
			return insert;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int update(final String sqlId, Object obj) {
		log.debug("updateing User user");
		try {
			int update = sqlSession.update(sqlId, obj);
			log.debug("delete successful");
			return update;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	public int delete(final String sqlId, Object obj) {
		log.debug("deleting User user");
		try {
			int delete = sqlSession.delete(sqlId, obj);
			log.debug("delete successful");
			return delete;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void getSession(String key) {
		if (sessionMap != null) {
			sqlSession = this.sessionMap.get(key);
		} else {
			throw new NullPointerException();
		}
	}
}
