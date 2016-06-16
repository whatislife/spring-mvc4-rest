package com.cnblogs.yjmyzz.dto;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.cnblogs.yjmyzz.enums.SEX;

@XmlRootElement(name = "order")
public class Order {

	String id;
	String clientName;
	
	@NumberFormat(style=Style.CURRENCY)
	//@NumberFormat(pattern="#,###.00")
	double amount;
	
	SEX sex;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date createTime;

	public Order() {
		this(null, null, 0, new Date(), SEX.Unknown);
	}

	public Order(String id, String clientName, double amount, Date createTime,
			SEX sex) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.amount = amount;
		this.createTime = createTime;
		this.sex = sex;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)amount;
		result = prime * result
				+ ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Order other = (Order) obj;
		if (amount != other.amount)
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "id:" + id + ",clientName:" + clientName + ",amount:" + amount
				+ ",createTime:" + createTime + ",sex:" + sex;
	}

	public SEX getSex() {
		return sex;
	}

	public void setSex(SEX sex) {
		this.sex = sex;
	}

}
