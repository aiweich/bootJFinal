package com.demo.boot.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOrderMaster<M extends BaseOrderMaster<M>> extends Model<M> implements IBean {

	public void setOrderId(String orderId) {
		set("order_id", orderId);
	}

	public String getOrderId() {
		return getStr("order_id");
	}

	public void setBuyerName(String buyerName) {
		set("buyer_name", buyerName);
	}

	public String getBuyerName() {
		return getStr("buyer_name");
	}

	public void setBuyerPhone(String buyerPhone) {
		set("buyer_phone", buyerPhone);
	}

	public String getBuyerPhone() {
		return getStr("buyer_phone");
	}

	public void setBuyerAddress(String buyerAddress) {
		set("buyer_address", buyerAddress);
	}

	public String getBuyerAddress() {
		return getStr("buyer_address");
	}

	public void setBuyerOpenid(String buyerOpenid) {
		set("buyer_openid", buyerOpenid);
	}

	public String getBuyerOpenid() {
		return getStr("buyer_openid");
	}

	public void setOrderAmount(java.math.BigDecimal orderAmount) {
		set("order_amount", orderAmount);
	}

	public java.math.BigDecimal getOrderAmount() {
		return get("order_amount");
	}

	public void setOrderStatus(Integer orderStatus) {
		set("order_status", orderStatus);
	}

	public Integer getOrderStatus() {
		return getInt("order_status");
	}

	public void setPayStatus(Integer payStatus) {
		set("pay_status", payStatus);
	}

	public Integer getPayStatus() {
		return getInt("pay_status");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}
	
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}