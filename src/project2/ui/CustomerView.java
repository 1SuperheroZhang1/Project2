package project2.ui;

import project2.bean.Customer;
import project2.service.CustomerList;
import project2.util.CMUtility;

/**
 * CustomerViewΪ��ģ�飬����˵�����ʾ�ʹ����û��Ĳ�����
 * */
public class CustomerView {
	CustomerList customerList=new CustomerList(10);
	 public CustomerView(){
		 Customer customer=new Customer("����",'Ů',20,"13879848525","zs@qq.com");
		 customerList.addCustomer(customer);
	 }
	/**
	 * ��ʾ<<�ͻ���Ϣ�������>>����Ĳ���
	 * */
	public void enterMainMenu() {
			boolean isFlag=true;
			while(isFlag) {
				System.out.println("----------------�ͻ���Ϣ�������-------------------");
				System.out.println("\n");
				System.out.println("1.��ӿͻ�");
				System.out.println("2.�޸Ŀͻ�");
				System.out.println("3.ɾ���ͻ�");
				System.out.println("4.�ͻ��б�");
				System.out.println("5.��    ��\n");
				System.out.println("������(1-5):");
				char menu = CMUtility.readMenuSelection();
				switch(menu) {
				case '1':
					addNewCustomer();
					break;
				case '2':
					modifyCustomer();
					break;
				case '3':
					deleteCustomer();
					break;
				case '4':
					listAllCustomer();
					break;
				case '5':
					System.out.print("ȷ���Ƿ��˳�(Y/N):");
					char isExit = CMUtility.readConfirmSelection();
					if(isExit=='Y') {
						isFlag=false;
					}
					
					break;
					
				}
			}
	
			
	}
	/**
	 * ��ӿͻ��Ĳ���
	 * */
	public void addNewCustomer() {
		System.out.println("----------------��ӿͻ�-------------------");
		System.out.print("����:");
		String name = CMUtility.readString(10);
		System.out.print("�Ա�:");
		char sex = CMUtility.readChar();
		System.out.print("����:");
		int age = CMUtility.readInt();
		System.out.print("�绰:");
		String tele = CMUtility.readString(13);
		System.out.print("����:");
		String email = CMUtility.readString(30);
		
		//���������ݷ�װ��������
		Customer customer=new Customer(name,sex,age,tele,email);
		
		boolean isSuccess = customerList.addCustomer(customer);
		if(isSuccess) {
			System.out.println("----------------��ӳɹ�-------------------");
		}else {
			System.out.println("----------------�ͻ�Ŀ¼���������ʧ��-------------------");
		}
	}
	/**
	 * �޸Ŀͻ��Ĳ���
	 * */
	public void modifyCustomer() {
		System.out.println("----------------�޸Ŀͻ�-------------------");
		Customer cust;
		int number;
		for(;;) {
			System.out.print("��ѡ����޸Ŀͻ��ı��(-1�˳�):");
			 number = CMUtility.readInt();
			
			if(number==-1) {
				return;
			}
			
			cust = customerList.getCustomer(number-1);
			if(cust==null) {
				System.out.println("�޷��ҵ�ָ���ͻ���");
			}else {//�ҵ�����Ӧ�Ŀͻ�
				break;
			}
		}
		//�޸Ŀͻ���Ϣ
		System.out.print("����("+cust.getName()+"):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("�Ա�("+cust.getGender()+"):");
		char sex = CMUtility.readChar(cust.getGender());
		System.out.print("����("+cust.getAge()+"):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("�绰("+cust.getPhone()+"):");
		String tele = CMUtility.readString(13, cust.getPhone());
		System.out.print("����("+cust.getEmail()+"):");
		String email = CMUtility.readString(30, cust.getEmail());
		
		Customer newCust=new Customer(name,sex,age,tele,email);
		boolean isReplaced = customerList.replaceCustomer(number-1, newCust);
		if(isReplaced) {
			System.out.println("----------------�޸����-------------------");
		}else {
			System.out.println("----------------�޸�ʧ��-------------------");
		}
		
	}
	/**
	 * ɾ���ͻ��Ĳ���
	 * */
	public void deleteCustomer() {
		System.out.println("----------------ɾ���ͻ�-------------------");
		int number;
		for(;;) {
			System.out.print("��ѡ����޸Ŀͻ��ı��(-1�˳�):");
			number = CMUtility.readInt();
			
			if(number==-1) {
				return;
			}
			
			Customer customer = customerList.getCustomer(number-1);
			if(customer==null) {
				System.out.println("�޷��ҵ�ָ���ͻ���");
			}else {//�ҵ�����Ӧ�Ŀͻ�
				break;
			}
		}
		//ɾ��ָ���ͻ�
		System.out.print("ȷ���Ƿ�ɾ��(Y/N):");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete=='Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number-1);
			if(deleteSuccess) {				
				System.out.println("----------------ɾ�����-------------------");
			}else {
				System.out.println("----------------ɾ��ʧ��-------------------");
			}
		}else {
			return;
		}
		
	}
	/**
	 * ��ʾ�ͻ��б�Ĳ���
	 * */
	public void listAllCustomer() {
		System.out.println("----------------�ͻ��б�-------------------");
		
		int total = customerList.getTotal();
		if(total==0) {
			System.out.println("û�пͻ���¼��");
		}else {
			System.out.println("���\t����\t�Ա�\t����\t�绰\t\t����");
			Customer[] custs = customerList.getAllCustomer();
			for(int i=0;i<custs.length;i++) {
				Customer customer = custs[i];
				System.out.println((i+1)+"\t"+customer.getName()+"\t"+customer.getGender()+"\t"+customer.getAge()+"\t"+customer.getPhone()+'\t'+customer.getEmail());
			}
			
		}
		System.out.println("----------------�ͻ��б����-------------------");
	}
	public static void main(String[] args) {
		CustomerView view =new CustomerView();
		view.enterMainMenu();
	}
}
