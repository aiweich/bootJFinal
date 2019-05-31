package com.demo.boot.service;

import com.demo.boot.dto.OrderDto;
import com.demo.boot.model.OrderMaster;
import com.demo.boot.vo.OrderVo;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.tx.TxConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/21 11:06
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	@Override
	public List<OrderVo> orderList(OrderDto orderDto) {
		List<OrderMaster> orderMasters = OrderMaster.dao.find("select * from order_master where order_status = ?", orderDto.getOrderStatus());
		List<OrderVo> orderList = new ArrayList<>();
		orderMasters.forEach(o->{
			OrderVo orderVo = new OrderVo();
			BeanUtils.copyProperties(o,orderVo);
			orderList.add(orderVo);
		});
		return orderList;
	}

	public boolean updateOrderStatus(OrderDto orderDto){
		Db.tx(new IAtom() {
			@Override
			public boolean run() throws SQLException {
				try {
					OrderMaster orderMaster = OrderMaster.dao.findById(orderDto.getOrderId());
					orderMaster.setOrderStatus(orderDto.getOrderStatus());
					boolean update = orderMaster.update();
					int i=1/0;
					return update;
				}catch (Exception e){
					log.error("update error",e);
					return false;
				}
			}
		});
		return false;
	}
}
