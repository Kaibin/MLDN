package scut.labtalk.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import scut.labtalk.domain.Admin;

@Component
public interface AdminDao {
	// �޸��������
	public void updatepwd(String adminid, String adminpwd) throws Exception;
	
	// �жϹ���Ա�Ƿ�����
	public boolean isExists(String adminid) throws Exception ;

	// ���ӹ���Ա
	public void insert(Admin admin) throws Exception;

	// ɾ������Ա
	public void delete(String adminid) throws Exception;

	// �г�ȫ���Ĺ���Ա
	public List queryAll() throws Exception;

	// �޸�����֮ǰ��������֤ԭ���������Ƿ���ȷ
	public boolean checkOldpwd(String adminid, String oldpwd) throws Exception;

	public boolean login(Admin admin) throws Exception ;
	
}
