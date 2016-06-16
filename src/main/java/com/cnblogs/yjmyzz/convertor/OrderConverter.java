package com.cnblogs.yjmyzz.convertor;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.entity.TOrder;
import com.cnblogs.yjmyzz.enums.SEX;
import com.cnblogs.yjmyzz.util.NumberUtil;

public class OrderConverter {

	public static Order toDto(TOrder entity) {
		Order order = new Order();
		if (entity == null) {
			return order;
		}
		order.setAmount(NumberUtil.getDoubleValue(entity.getAmount()));
		order.setClientName(entity.getClientname());
		order.setCreateTime(entity.getCreatetime());
		order.setId("" + NumberUtil.getIntValue(entity.getId()));
		order.setSex(SEX.get(entity.getSex()));
		return order;
	}

	public static TOrder toEntity(Order dto) {
		TOrder entity = new TOrder();
		if (dto == null) {
			return entity;
		}
		entity.setAmount(new BigDecimal(dto.getAmount()));
		entity.setClientname(dto.getClientName());
		entity.setCreatetime(dto.getCreateTime());
		entity.setSex(dto.getSex().getValue());
		if (StringUtils.isEmpty(dto.getId())) {
			entity.setId(null);
		} else {
			entity.setId(new BigDecimal(Integer.parseInt(dto.getId())));
		}
		return entity;

	}
}
