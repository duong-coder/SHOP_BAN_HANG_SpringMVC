package com.duong.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duong.model.OrderDTO;
import com.duong.model.OrderDetailDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.UserDTO;
import com.duong.service.ProductDetailService;

@RequestMapping("/order")
@RestController
public class OrderAPI {

	@Autowired
	private ProductDetailService productDetailService;

	@RequestMapping(value = "/add-item", method = RequestMethod.GET)
	public void addItemInOrder(HttpSession session, @RequestParam("maSP") String maSP, @RequestParam("maMau") int maMau,
			@RequestParam("maSize") int maSize) {
		OrderDTO order = (OrderDTO) session.getAttribute("order");
		if (order != null) {
			UserDTO userDTO = order.getUser();
			Date date = order.getDate();
			boolean status = order.isStatus();
			List<OrderDetailDTO> orderDetailDTOs = order.getOrderDetailDTOs();
			boolean flagAddItem = true;

			for (OrderDetailDTO item : orderDetailDTOs) {
				String sp = item.getProductDetail().getProductDTO().getMaSp();
				int color = item.getProductDetail().getColor().getId();
				int size = item.getProductDetail().getSize().getId();

				if (sp.equals(maSP) && color == maMau && size == maSize) {
					flagAddItem = false;
					item.setAmount(item.getAmount() + 1);
				}
			}
			if (flagAddItem) {
				OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
				ProductDetailDTO detailDTO = new ProductDetailDTO();

				try {
					detailDTO = productDetailService.getProductDetail(maSP, maMau, maSize);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				orderDetailDTO.setProductDetail(detailDTO);
				orderDetailDTO.setAmount(1);

				orderDetailDTOs.add(orderDetailDTO);
			}

			order.setUser(userDTO);
			order.setDate(date);
			order.setStatus(false);
			order.setOrderDetailDTOs(orderDetailDTOs);
		} else {
			order = new OrderDTO();

			UserDTO userDTO = (UserDTO) session.getAttribute("userLogin");
			Date date = new Date();
			List<OrderDetailDTO> orderDetailDTOs = new ArrayList<OrderDetailDTO>();
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
			ProductDetailDTO detailDTO = new ProductDetailDTO();

			try {
				detailDTO = productDetailService.getProductDetail(maSP, maMau, maSize);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			orderDetailDTO.setProductDetail(detailDTO);
			orderDetailDTO.setAmount(1);

			orderDetailDTOs.add(orderDetailDTO);

			order.setUser(userDTO);
			order.setDate(date);
			order.setStatus(false);
			order.setOrderDetailDTOs(orderDetailDTOs);

		}
		session.setAttribute("order", order);
	}
}
