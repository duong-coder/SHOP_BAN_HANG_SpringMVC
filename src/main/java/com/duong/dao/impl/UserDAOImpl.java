package com.duong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duong.dao.UserDAO;
import com.duong.entity.Nguoidung;

@Repository
//@Transactional
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertUser(Nguoidung nguoidung) throws SQLException {
		Session session = sessionFactory.openSession();
		session.save(nguoidung);
		session.close();
	}

	@Override
	public void updateUser(Nguoidung nguoidung) throws SQLException {
		Session session = sessionFactory.openSession();
		session.update(nguoidung);
		session.flush();
		session.close();
	}

	@Override
	public void deleteUserById(int id) throws SQLException {
		Session session = sessionFactory.openSession();
		Nguoidung nguoidung = (Nguoidung) session.get(Nguoidung.class, id);
		session.delete(nguoidung);
		session.flush();
		session.close();
	}

	@Override
	public Nguoidung getUserById(int id) throws SQLException {
		Session session = sessionFactory.openSession();
		Nguoidung nguoidung = (Nguoidung) session.get(Nguoidung.class, id);
		session.close();
		return nguoidung;
	}

	@Override
	public List<Nguoidung> getAllUser() throws SQLException {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Nguoidung.class);
		return criteria.list();
	}
	
	@Override
	public Nguoidung getSignInByMaNguoiDung(String usename, String password) throws SQLException{
		Session session = sessionFactory.openSession();
		String hql = "from Nguoidung where maNguoiDung = :username AND matKhau = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username",usename);
		query.setParameter("password",password);
		Object object = query.uniqueResult();
		Nguoidung nguoidung = null;
		if(object != null) {
			nguoidung = (Nguoidung) object;
		}
		return nguoidung;
	}
}
