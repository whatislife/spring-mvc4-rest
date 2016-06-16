package com.cnblogs.yjmyzz.test;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "sample")
@XStreamAlias("sample")
public class Sample implements Serializable{	
	
	private static final long serialVersionUID = -6271703229325404123L;

	private Double amount;
	
	
	private Date createDate;

	@XmlJavaTypeAdapter(JaxbNumberAdapter.class) 
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@XmlJavaTypeAdapter(JaxbDateAdapter.class) 
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
