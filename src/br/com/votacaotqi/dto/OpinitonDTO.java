package br.com.votacaotqi.dto;

import br.com.votacaotqui.entity.Item;
import br.com.votacaotqui.entity.Opinion;

public class OpinitonDTO {
	
	private String answer;
	private Item item;
	private String ip;
	
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
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
	
	public Opinion toEntity(){
		
		Opinion opinion = new Opinion();
		opinion.setIp(this.ip);
		opinion.setItem(this.item);
		
		return opinion;
		
	}

}
