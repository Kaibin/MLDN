package scut.labtalk.service;

import java.util.List;

import org.springframework.stereotype.Component;

import scut.labtalk.domain.Item;
@Component
public interface ItemService {

	// 得到全部的栏目
	public List<Item> getAllItem() throws Exception;

	// 删除栏目
	public void delete(Item item) throws Exception;

	// 更新栏目
	public void update(Item item) throws Exception;

	// 按栏目ID查询
	public Item qetById(String itemid) throws Exception;
	
	// 增加新栏目
	public void save(Item item) throws Exception ;
}
