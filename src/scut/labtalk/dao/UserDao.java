package scut.labtalk.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import scut.labtalk.domain.User;
@Component
public interface UserDao {
	// ��userid�����û�
	public User queryByUserid(String userid) throws Exception;

	// �û�ע��
	public void persist(User user) throws Exception;

	// ��½��֤
	public boolean login(User user) throws Exception;

	// �һ�������� --> �����û��޸�����
	public void updateUserpwd(String userid, String userpwd) throws Exception;

	// ������ʾ���⡢�𰸡��û���ȷ�����û��Ƿ����
	public boolean isExists(String userid, String userques, String userans)
			throws Exception;

	// ���ӵ÷�
	public void addIntegral(String userid, int itergral) throws Exception;

	// �����û�
	public void update(User user) throws Exception;

	// �г�ȫ���û�
	public List<User> queryAll(int currentPage, int lineSize) throws Exception;

	// ���ȫ���ļ�¼��
	public int getAllCount() throws Exception;

	// ɾ���û�
	public void delete(User user) throws Exception;

	// �޸��û�����
	public void updateIntegral(String userid, int integral) throws Exception;

}
