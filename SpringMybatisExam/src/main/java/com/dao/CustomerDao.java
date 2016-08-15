package com.dao;

import com.Bean.Customer;

public interface CustomerDao {
	public Customer selectCustomer(int id);
	public boolean checkAddressId(int id);
	public int insertCustomer(Customer customer);
	public Customer selectLastCustomer();
}
