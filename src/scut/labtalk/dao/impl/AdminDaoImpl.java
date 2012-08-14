package scut.labtalk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import scut.labtalk.dao.AdminDao;
import scut.labtalk.domain.Admin;

//@Repository("admindao")
//@Component
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
	// 必须是经过MD5加密之后才可以
	public boolean checkOldpwd(String adminid, String oldpwd) throws Exception {
		boolean flag = false;
		String hql = "FROM Admin AS a WHERE a.adminid=?";
		Query q = super.getSession().createQuery(hql);
		q.setString(0, adminid);
		List all = q.list();
		if (all.size() > 0) {
			Admin admin = (Admin) q.list().get(0);
			if (admin.getAdminpwd().equals(oldpwd)) {
				flag = true;
			}
		}
		return flag;
	}

	public void delete(String adminid) throws Exception {
		String hql = "DELETE FROM Admin WHERE adminid=?";
		Query q = super.getSession().createQuery(hql);
		q.setString(0, adminid);
		q.executeUpdate();
	}

	public void insert(Admin admin) throws Exception {
		super.getSession().save(admin);
	}

	public List queryAll() throws Exception {
		List all = null;
		String hql = "From Admin AS a";
		Query q = super.getSession().createQuery(hql);
		all = q.list();
		return all;
	}

	public void updatepwd(String adminid, String adminpwd) throws Exception {
		String hql = "UPDATE Admin SET adminpwd=? WHERE adminid=?";
		Query q = super.getSession().createQuery(hql);
		q.setString(0, adminpwd);
		q.setString(1, adminid);
		q.executeUpdate();
	}

	public boolean isExists(String adminid) throws Exception {
		boolean flag = false;
		String hql = "From Admin AS a WHERE a.adminid=?";
		Query q = super.getSession().createQuery(hql);
		q.setString(0, adminid);
		List all = q.list();
		if (all.size() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean login(Admin admin) throws Exception {
		boolean flag = false;
		String hql = "FROM Admin AS a WHERE a.adminid=? AND a.adminpwd=?";
		Query q = super.getSession().createQuery(hql);
		q.setString(0, admin.getAdminid());
		q.setString(1, admin.getAdminpwd());
		List all = q.list();
		if (all.size() > 0) {
			flag = true;
		}
		return flag;
	}

}
