package project2.service;

import project2.bean.Customer;

/**
 * CustomerListΪCustomer����Ĺ���ģ�飬�ڲ����������һ��Customer����
 * ���ṩ��Ӧ����ӡ�ɾ�����޸ġ���ѯ��������CustomerView����
 * */
public class CustomerList {
	private Customer[] customers;//��������ͻ����������
	private int total=0;//��¼�ѱ���ͻ����������
	/**
	 * ��;:������,������ʼ��Customers����
	 * totalCustomer:����ָ�����鳤��
	 * */
	public CustomerList(int totalCustomer) {
		customers=new Customer[totalCustomer];
	}
	/**
	 * ��ָ���Ŀͻ���ӵ�������
	 * ��ӳɹ� ����true 
	 * ���ʧ�� ����false
	 * */
	public boolean addCustomer(Customer customer) {
		if(total>=customers.length) {
			return false;
		}
//		customers[total]=customer;
//		total++;
		//��
		customers[total++]=customer;
		return true;
	}
	/**
	 * �޸�ָ������λ�ÿ͑�����Ϣ
	 * �޸ĳɹ� ����true
	 * �޸�ʧ�� ����false
	 * */
	public boolean replaceCustomer(int index,Customer cust) {
			if(index<0 || index>=total) {
				return false;
			}
			customers[index]=cust;
			return true;
	}
	/**
	 * ɾ��ָ������λ�õĿͻ�
	 * ɾ���ɹ� ����true
	 * ɾ��ʧ�� ����false
	 * */
	public boolean deleteCustomer(int index) {
		if(index<0 || index>=total) {
			return false;
		}
		for(int i=index;i<total-1;i++) {
			customers[i]=customers[i+1];
		}
		//��������ݵ�Ԫ����Ҫ�ÿ�
//		customers[total-1]=null;
//		total--;
		//��
		customers[total--]=null;
		return true;
	}
	/**
	 * ��ȡ���пͻ�����Ϣ
	 * */
	public Customer[] getAllCustomer() {
		Customer[] custs=new Customer[total];
		for(int i=0;i<total;i++) {
			custs[i]=customers[i];
		}
		return custs;
	}
	/**
	 * ��ȡָ������λ���ϵĿͻ�
	 * ����ҵ� �򷵻�
	 * ���û�� �򷵻�null
	 * */
	public Customer getCustomer(int index) {
			if(index<0 || index>=total) {
				return null;
			}
			return customers[index];
	}
	/**
	 * ��ȡ�洢�Ŀͻ�����
	 * */
	public int getTotal() {
		return total;
	}
	
	
}
