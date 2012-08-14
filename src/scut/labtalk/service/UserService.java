package scut.labtalk.service;

import java.util.List;

import scut.labtalk.domain.User;

public interface UserService {

	// 按userid查找用户
	public User getByUserid(String userid) throws Exception;

	// 用户注册
	public void register(User user) throws Exception;

	// 登陆验证
	public boolean login(User user) throws Exception;

	// 找回密码操作 --> 允许用户修改密码
	public void updateUserpwd(String userid, String userpwd) throws Exception;

	// 根据提示问题、答案、用户名确定此用户是否存在
	public boolean isExists(String userid, String userques, String userans) throws Exception;

	// 增加得分
	public void addIntegral(String userid, int itergral) throws Exception;

	// 更新用户
	public void update(User user) throws Exception;

	// 列出全部用户
	public List<User> getAllUser(int currentPage, int lineSize) throws Exception;

	// 求出全部的记录数
	public long getAllCount() throws Exception;

	// 删除用户
	public void delete(User user) throws Exception;

	// 修改用户积分
	public void updateIntegral(String userid, int integral) throws Exception;
}
