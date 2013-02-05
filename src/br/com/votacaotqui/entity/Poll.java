package br.com.votacaotqui.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;


@Entity
public class Poll extends AbstractEntity {
	
	private String description;
	
	@OneToMany(mappedBy="poll", fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Item> items;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	 
	public List<Item> getItems() {
		return items;
	}
	
	public void setItens(List<Item> items) {
		this.items = items;
	}
	
	public int totalOpinions(){
		
		int total = 0;
		
		for(Item item :this.items)
			total +=item.totalOpinions();
		
		return total;
	}

}
