package scut.labtalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import scut.labtalk.dao.UserDao;
import scut.labtalk.domain.User;
import scut.labtalk.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userdao;
	
	@Override
	public User getByUserid(String userid) throws Exception {
		return userdao.queryByUserid(userid);
	}

	@Override
	public void register(User user) throws Exception {
		userdao.persist(user);
	}

	@Override
	public boolean login(User user) throws Exception {
		return userdao.login(user);
	}

	@Override
	public void updateUserpwd(String userid, String userpwd) throws Exception {
		userdao.updateUserpwd(userid, userpwd);		
	}

	@Override
	public boolean isExists(String userid, String userques, String userans) throws Exception {
		return userdao.isExists(userid, userques, userans);
	}

	@Override
	public void addIntegral(String userid, int itergral) throws Exception {
		userdao.addIntegral(userid, itergral);		
	}

	@Override
	public void update(User user) throws Exception {
		userdao.update(user);		
	}

	@Override
	public List<User> getAllUser(int currentPage, int lineSize)throws Exception {
		return userdao.queryAll(currentPage, lineSize);
	}

	@Override
	public long getAllCount() throws Exception {
		return userdao.getAllCount();
	}

	@Override
	public void delete(User user) throws Exception {
		userdao.delete(user);		
	}

	@Override
	public void updateIntegral(String userid, int integral) throws Exception {
		userdao.updateIntegral(userid, integral);		
	}
	
	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}



}
