package scut.labtalk.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import scut.labtalk.domain.Admin;

@Component
public interface AdminDao {
	// 修改密码操作
	public void updatepwd(String adminid, String adminpwd) throws Exception;
	
	// 判断管理员是否重名
	public boolean isExists(String adminid) throws Exception ;

	// 增加管理员
	public void insert(Admin admin) throws Exception;

	// 删除管理员
	public void delete(String adminid) throws Exception;

	// 列出全部的管理员
	public List queryAll() throws Exception;

	// 修改密码之前必须先验证原来的密码是否正确
	public boolean checkOldpwd(String adminid, String oldpwd) throws Exception;

	public boolean login(Admin admin) throws Exception ;
	
}
