package com.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.Bean.Customer;

public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao {

	public Customer selectCustomer(int id) {
		SqlSession sqlSession=this.getSqlSession();
		Customer customer = sqlSession.selectOne("selectCustomer", id);
		return customer;
	}

	public boolean checkAddressId(int id) {
		boolean b = false;
		SqlSession sqlSession=this.getSqlSession();
		int i = sqlSession.selectOne("checkAddressId", id);
		if(i == 1){
			b = true;
		}
		return b;
	}

	public int insertCustomer(Customer customer) {
		int i = 0;
		SqlSession sqlSession=this.getSqlSession();
		i = sqlSession.insert("insertCustomer", customer);
		return i;
		
	}

	public Customer selectLastCustomer() {
		SqlSession sqlSession=this.getSqlSession();
		Customer customer = sqlSession.selectOne("selectLastOne");
		return customer;
	}

}
