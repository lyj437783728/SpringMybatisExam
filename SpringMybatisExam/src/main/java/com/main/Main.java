package com.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Bean.Customer;
import com.dao.CustomerDao;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("com/hand/ApplicationContext.xml");
		CustomerDao cd = (CustomerDao) context.getBean("customerDao");
//		Customer customer = (Customer) context.getBean("customer");
//		System.out.println(customer);
//		CustomerDao cd = (CustomerDao) context.getBean("customerDao");
//		Customer customer = cd.selectCustomer(2);
//		System.out.println(customer);
		int addressId;
		boolean pass = true;
		Customer customer = (Customer) context.getBean("customer");
		customer.setStore_id(1);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入 FirstName(first_name):");
		customer.setFirst_name(input.nextLine());
//		System.out.println(customer);
		System.out.println("请输入 LastName(last_name):");
		customer.setLast_name(input.nextLine());
		System.out.println("请输入 Email(email):");
		customer.setEmail(input.nextLine());
		System.out.println("请输入 Address	ID:");
		
		addressId = input.nextInt();
		if(cd.checkAddressId(addressId)){
			customer.setAddress_id(addressId);
		}else{
			while(pass){
				System.out.println("你输入的 AddressID 不存在,请重新输入:");
				addressId = input.nextInt();
				if(cd.checkAddressId(addressId)){
					customer.setAddress_id(addressId);
					pass = false;
				}
			}
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		customer.setCreate_date(date);
		System.out.println(customer);
		
		int successed = cd.insertCustomer(customer);
		if(successed == 1){
			System.out.println("插入成功，已经保存的数据如下：");
		}
		Customer last = cd.selectLastCustomer();
		System.out.println("ID:"+last.getCustomer_id());
		System.out.println("FirstName:"+last.getFirst_name());
		System.out.println("FirstName:"+last.getLast_name());
		System.out.println("Email:"+last.getEmail());
		System.out.println("Address:"+last.getAddress());
	}

}
