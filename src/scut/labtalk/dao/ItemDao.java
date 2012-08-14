package scut.labtalk.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import scut.labtalk.domain.Item;
@Component
public interface ItemDao {
	// 得到全部的栏目
	public List<Item> queryAll() throws Exception;

	// 删除栏目
	public void delete(Item item) throws Exception;

	// 更新栏目
	public void update(Item item) throws Exception;

	// 按栏目ID查询
	public Item queryById(String itemid) throws Exception;
	
	// 增加新栏目
	public void insert(Item item) throws Exception ;
}
