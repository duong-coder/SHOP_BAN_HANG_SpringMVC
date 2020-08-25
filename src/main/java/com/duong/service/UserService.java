package com.duong.service;

import java.sql.SQLException;
import java.util.List;

import com.duong.model.UserDTO;

public interface UserService {
//	void insertUser(UserDTO userDTO) throws HibernateException;
//
//	void updateUser(UserDTO userDTO) throws HibernateException;
//
//	void deleteUserById(int id) throws HibernateException;
//
//	UserDTO getUserById(int id) throws HibernateException;
//
//	List<UserDTO> getAllUser() throws HibernateException;

	List<UserDTO> getAllUser() throws SQLException;

	UserDTO getUserById(int id) throws SQLException;

	void deleteUserById(int id) throws SQLException;

	void updateUser(UserDTO userDTO) throws SQLException;

	void insertUser(UserDTO userDTO) throws SQLException;

	UserDTO getSignInByMaNguoiDung(String username, String password) throws SQLException;
}
