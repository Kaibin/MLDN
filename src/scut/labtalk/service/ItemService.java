package scut.labtalk.service;

import java.util.List;
import scut.labtalk.domain.Item;

public interface ItemService {

	// �õ�ȫ������Ŀ
	public List<Item> getAllItem() throws Exception;

	// ɾ����Ŀ
	public void delete(Item item) throws Exception;

	// ������Ŀ
	public void update(Item item) throws Exception;

	// ����ĿID��ѯ
	public Item qetById(String itemid) throws Exception;
	
	// ��������Ŀ
	public void save(Item item) throws Exception ;
}
