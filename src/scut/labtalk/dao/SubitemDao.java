package scut.labtalk.dao;

import org.springframework.stereotype.Component;
import scut.labtalk.domain.Subitem;
//@Component
public interface SubitemDao {
	// ɾ����Ŀ
	public void delete(int subid) throws Exception;

	// ������Ŀ
	public void update(Subitem subitem) throws Exception;

	// ��������Ŀ
	public void insert(Subitem subitem) throws Exception;
}
