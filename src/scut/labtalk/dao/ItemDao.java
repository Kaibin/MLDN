package scut.labtalk.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import scut.labtalk.domain.Item;
@Component
public interface ItemDao {
	// �õ�ȫ������Ŀ
	public List<Item> queryAll() throws Exception;

	// ɾ����Ŀ
	public void delete(Item item) throws Exception;

	// ������Ŀ
	public void update(Item item) throws Exception;

	// ����ĿID��ѯ
	public Item queryById(String itemid) throws Exception;
	
	// ��������Ŀ
	public void insert(Item item) throws Exception ;
}
