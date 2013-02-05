package br.com.votacaotqi.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import br.com.votacaotqui.entity.Item;

public class ResultDTO {
	
	
	private List<ItemResult> items;
	private int total;
	
	
	
	public ResultDTO(int total){
		
		this.total = total;
		this.items = new ArrayList<ResultDTO.ItemResult>();
	}
	
	public void add(Item item){
		BigDecimal value = BigDecimal.ZERO;
		if(this.total>0 && item.totalOpinions()>0)
			value = new BigDecimal((item.totalOpinions()*100)).divide(new BigDecimal(this.total),2, RoundingMode.HALF_UP);
		
		this.items.add(new ItemResult(item.getName(),value));
	}
	
	public int getTotal() {
		return total;
	}
	
	public List<ItemResult> getItems() {
		return items;
	}
	
	public class ItemResult{
		
		private String name;
		private BigDecimal value;
		
		
		public ItemResult(String name, BigDecimal value){
			
			this.name = name;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		
		public BigDecimal getValue() {
			return value;
		}
	}
	
}
