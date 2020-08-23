package com.duong.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.duong.entity.Nguoidung;

public interface UserDAO {
//	void insertUser(Nguoidung nguoidung) throws HibernateException;
//
//	void updateUser(Nguoidung nguoidung) throws HibernateException;
//
//	void deleteUserById(int id) throws HibernateException;
//
//	Nguoidung getUserById(int id) throws HibernateException;
//
//	List<Nguoidung> getAllUser() throws HibernateException;

	List<Nguoidung> getAllUser() throws SQLException;

	Nguoidung getUserById(int id) throws SQLException;

	void deleteUserById(int id) throws SQLException;

	void updateUser(Nguoidung nguoidung) throws SQLException;

	void insertUser(Nguoidung nguoidung) throws SQLException;

	Nguoidung getSignInByMaNguoiDung(String usename, String password) throws SQLException;
}
