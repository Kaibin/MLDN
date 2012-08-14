package scut.labtalk.dao;

import org.springframework.stereotype.Component;
import scut.labtalk.domain.Subitem;
//@Component
public interface SubitemDao {
	// 删除栏目
	public void delete(int subid) throws Exception;

	// 更新栏目
	public void update(Subitem subitem) throws Exception;

	// 增加新栏目
	public void insert(Subitem subitem) throws Exception;
}
