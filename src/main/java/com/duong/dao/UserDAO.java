package com.duong.dao;

import java.sql.SQLException;
import java.util.List;

import com.duong.entity.NguoiDung;

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

	List<NguoiDung> getAllUser() throws SQLException;

	NguoiDung getUserById(int id) throws SQLException;

	void deleteUserById(int id) throws SQLException;

	void updateUser(NguoiDung nguoidung) throws SQLException;

	void insertUser(NguoiDung nguoidung) throws SQLException;

	NguoiDung getSignInByMaNguoiDung(String usename, String password) throws SQLException;
}
