package cn.ccnu.dao;

import java.util.ArrayList;

import cn.ccnu.pojo.Order;

public interface IOrderDao {
	//�����ݿ�Խӵĵײ�ӿ�
	
	//���һ�У������޸�������
	int add(Order order)throws Exception;
	//ɾ��ָ���У������޸�������
	int delete(int orderId)throws Exception;
	//����ָ���У������޸�������
	int updata(Order order)throws Exception;
	//��ѯ��ȡ������
	ArrayList<Order> getAllRow()throws Exception;
	//��ѯ��ȡһ��
	Order getOneRow( int orderId)throws Exception;
	
}
