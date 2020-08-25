package com.duong.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duong.dao.UserDAO;
import com.duong.entity.NguoiDung;
import com.duong.model.UserDTO;
import com.duong.service.UserService;

@Service
//@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public void insertUser(UserDTO userDTO) throws SQLException {
		NguoiDung nd = new NguoiDung();
		nd.setId(userDTO.getID());
		nd.setMaNguoiDung(userDTO.getUsername());
		nd.setMatKhau(userDTO.getPass());
		nd.setHoTen(userDTO.getName());
		nd.setGioiTinh(userDTO.isGender());
		nd.setEmail(userDTO.getEmail());
		nd.setSoDT(userDTO.getPhone());
		nd.setDiaChi(userDTO.getAddress());
		nd.setRole(userDTO.getRole());

		userDAO.insertUser(nd);
	}

	@Override
	public void updateUser(UserDTO userDTO) throws SQLException {
		NguoiDung nd = new NguoiDung();
		nd.setId(userDTO.getID());
		nd.setMaNguoiDung(userDTO.getUsername());
		nd.setMatKhau(userDTO.getPass());
		nd.setHoTen(userDTO.getName());
		nd.setGioiTinh(userDTO.isGender());
		nd.setEmail(userDTO.getEmail());
		nd.setSoDT(userDTO.getPhone());
		nd.setDiaChi(userDTO.getAddress());
		nd.setRole(userDTO.getRole());

		userDAO.updateUser(nd);

	}

	@Override
	public void deleteUserById(int id) throws SQLException {
		UserDTO dto = getUserById(id);
		if (dto != null) {
			userDAO.deleteUserById(id);
		}
	}

	@Override
	public UserDTO getUserById(int id) throws SQLException {
		NguoiDung nd = userDAO.getUserById(id);
		UserDTO dto = new UserDTO();
		dto.setID(nd.getId());
		dto.setUsername(nd.getMaNguoiDung());
		dto.setPass(nd.getMatKhau());
		dto.setName(nd.getHoTen());
		dto.setGender(nd.getGioiTinh());
		dto.setEmail(nd.getEmail());
		dto.setAddress(nd.getDiaChi());
		dto.setPhone(nd.getSoDT());
		dto.setRole(nd.getRole());

		return dto;
	}

	@Override
	public List<UserDTO> getAllUser() throws SQLException {
		List<NguoiDung> nds = userDAO.getAllUser();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		nds.forEach((nd) -> {
			UserDTO dto = new UserDTO();
			dto.setID(nd.getId());
			dto.setUsername(nd.getMaNguoiDung());
			dto.setPass(nd.getMatKhau());
			dto.setName(nd.getHoTen());
			dto.setGender(nd.getGioiTinh());
			dto.setEmail(nd.getEmail());
			dto.setAddress(nd.getDiaChi());
			dto.setPhone(nd.getSoDT());
			dto.setRole(nd.getRole());

			userDTOs.add(dto);
		});
		return userDTOs;
	}

	@Override
	public UserDTO getSignInByMaNguoiDung(String username, String password) throws SQLException {
		NguoiDung nd = userDAO.getSignInByMaNguoiDung(username, password);
		if (nd == null) {
			return null;
		}
		UserDTO dto = new UserDTO();
		dto.setID(nd.getId());
		dto.setUsername(nd.getMaNguoiDung());
		dto.setPass(nd.getMatKhau());
		dto.setName(nd.getHoTen());
		dto.setGender(nd.getGioiTinh());
		dto.setEmail(nd.getEmail());
		dto.setAddress(nd.getDiaChi());
		dto.setPhone(nd.getSoDT());
		dto.setRole(nd.getRole());

		return dto;
	}
}
