package com.demo.boot.controller;

import com.demo.boot.dto.OrderDto;
import com.demo.boot.service.OrderService;
import com.demo.boot.vo.OrderVo;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/21 11:01
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@PostMapping("/list")
	public List<OrderVo> orderList(@RequestBody OrderDto orderDto){
		List<OrderVo> orderList = orderService.orderList(orderDto);
		return  orderList;
	}

	@PostMapping("/update")
	public boolean update(@RequestBody OrderDto orderDto){
		return orderService.updateOrderStatus(orderDto);
	}
}
