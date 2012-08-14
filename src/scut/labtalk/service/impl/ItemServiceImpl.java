package scut.labtalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import scut.labtalk.dao.ItemDao;
import scut.labtalk.domain.Item;
import scut.labtalk.service.ItemService;

public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemDao itemdao;

	public ItemDao getItemdao() {
		return itemdao;
	}

	public void setItemdao(ItemDao itemdao) {
		this.itemdao = itemdao;
	}

	@Override
	public List<Item> getAllItem() throws Exception {
		return itemdao.queryAll();
	}

	@Override
	public void delete(Item item) throws Exception {
		itemdao.delete(item);
		
	}

	@Override
	public void update(Item item) throws Exception {
		itemdao.update(item);
		
	}

	@Override
	public Item qetById(String itemid) throws Exception {
		return itemdao.queryById(itemid);
	}

	@Override
	public void save(Item item) throws Exception {
		itemdao.insert(item);
	}
}
