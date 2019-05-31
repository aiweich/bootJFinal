package com.demo.boot.service;

import com.demo.boot.dto.OrderDto;
import com.demo.boot.vo.OrderVo;

import java.util.List;

public interface OrderService {
	/**
	 *
	 * @param orderDto
	 * @return
	 */
	List<OrderVo> orderList(OrderDto orderDto);

	/**
	 *
	 * @param orderDto
	 * @return
	 */
	boolean updateOrderStatus (OrderDto orderDto);

}
