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
					item.setPrice(item.getProductDetail().getProductDTO().getGia() * item.getAmount());
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
				orderDetailDTO.setPrice(detailDTO.getProductDTO().getGia() * orderDetailDTO.getAmount());
				orderDetailDTOs.add(orderDetailDTO);
			}

			order.setUser(userDTO);
			order.setDate(date);
			order.setStatus(status);
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
			orderDetailDTO.setPrice(detailDTO.getProductDTO().getGia() * orderDetailDTO.getAmount());
			orderDetailDTOs.add(orderDetailDTO);

			order.setUser(userDTO);
			order.setDate(date);
			order.setStatus(false);
			order.setOrderDetailDTOs(orderDetailDTOs);

		}
		session.setAttribute("order", order);
	}

	@RequestMapping(value = "/delete-items-order", method = RequestMethod.POST)
	public void deleteMoreItemOrder(HttpSession session, @RequestParam(value="indexs[]") int[] indexs) {
		OrderDTO order = (OrderDTO) session.getAttribute("order");
		if (order != null) {
			List<OrderDetailDTO> orderDetailDTOs = order.getOrderDetailDTOs();
			for (int i = indexs.length - 1; i >= 0; i--) {
				orderDetailDTOs.remove(indexs[i]);
				System.out.println(indexs[i]);
			}
		}
	}
	
	@RequestMapping(value = "/change-amount-item", method = RequestMethod.POST)
	public String changeAmountItemInOrder(HttpSession session, @RequestParam("maSP") String maSP, @RequestParam("maMau") int maMau,
			@RequestParam("maSize") int maSize,
			@RequestParam("amount") int amountSpInItem) {
		OrderDTO order = (OrderDTO) session.getAttribute("order");
		List<OrderDetailDTO> orderDetailDTOs = order.getOrderDetailDTOs();
		for(OrderDetailDTO orderDetailDTO: orderDetailDTOs) {
			String maSPInArr = orderDetailDTO.getProductDetail().getProductDTO().getMaSp();
			int maSizeInArr = orderDetailDTO.getProductDetail().getSize().getId();
			int maMauInArr = orderDetailDTO.getProductDetail().getColor().getId();
			
			if(maSP.equals(maSPInArr) && maMau == maMauInArr && maSize == maSizeInArr) {
				orderDetailDTO.setAmount(amountSpInItem);
				orderDetailDTO.setPrice(orderDetailDTO.getProductDetail().getProductDTO().getGia() * orderDetailDTO.getAmount());
				
				return "" + orderDetailDTO.getPrice();
			}
		}
		
		return "0";
	}

	@RequestMapping(value = "/size-order", method = RequestMethod.GET)
	public String getSizeOrder(HttpSession session) {
		OrderDTO order = (OrderDTO) session.getAttribute("order");
		if (order != null) {
			List<OrderDetailDTO> orderDetailDTOs = order.getOrderDetailDTOs();
			return "" + orderDetailDTOs.size();
		} else {
			return "0";
		}
	}
}
