package br.com.votacaotqui.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Opinion extends AbstractEntity {
	
	
	@ManyToOne(fetch = FetchType.EAGER)  
    @JoinColumn(name = "item_id")  
    @Fetch(FetchMode.JOIN)  
	private Item item;
	
	private String ip;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}

}
