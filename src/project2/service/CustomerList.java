package project2.service;

import project2.bean.Customer;

/**
 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 * 并提供相应的添加、删除、修改、查询方法，供CustomerView调用
 * */
public class CustomerList {
	private Customer[] customers;//用来保存客户对象的数组
	private int total=0;//记录已保存客户对象的数量
	/**
	 * 用途:构造器,用来初始化Customers数组
	 * totalCustomer:用来指定数组长度
	 * */
	public CustomerList(int totalCustomer) {
		customers=new Customer[totalCustomer];
	}
	/**
	 * 将指定的客户添加到数组中
	 * 添加成功 返回true 
	 * 添加失败 返回false
	 * */
	public boolean addCustomer(Customer customer) {
		if(total>=customers.length) {
			return false;
		}
//		customers[total]=customer;
//		total++;
		//或
		customers[total++]=customer;
		return true;
	}
	/**
	 * 修改指定索引位置客戶的信息
	 * 修改成功 返回true
	 * 修改失败 返回false
	 * */
	public boolean replaceCustomer(int index,Customer cust) {
			if(index<0 || index>=total) {
				return false;
			}
			customers[index]=cust;
			return true;
	}
	/**
	 * 删除指定索引位置的客户
	 * 删除成功 返回true
	 * 删除失败 返回false
	 * */
	public boolean deleteCustomer(int index) {
		if(index<0 || index>=total) {
			return false;
		}
		for(int i=index;i<total-1;i++) {
			customers[i]=customers[i+1];
		}
		//最后有数据的元素需要置空
//		customers[total-1]=null;
//		total--;
		//或
		customers[total--]=null;
		return true;
	}
	/**
	 * 获取所有客户的信息
	 * */
	public Customer[] getAllCustomer() {
		Customer[] custs=new Customer[total];
		for(int i=0;i<total;i++) {
			custs[i]=customers[i];
		}
		return custs;
	}
	/**
	 * 获取指定索引位置上的客户
	 * 如果找到 则返回
	 * 如果没有 则返回null
	 * */
	public Customer getCustomer(int index) {
			if(index<0 || index>=total) {
				return null;
			}
			return customers[index];
	}
	/**
	 * 获取存储的客户数量
	 * */
	public int getTotal() {
		return total;
	}
	
	
}
