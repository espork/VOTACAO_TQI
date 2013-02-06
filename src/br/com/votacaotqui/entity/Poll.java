package br.com.votacaotqui.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Cascade;


@Entity
public class Poll extends AbstractEntity {
	
	private String description;
	
	@OneToMany(mappedBy="poll", fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@OrderBy("name ASC")
	private Set<Item> items;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	 
	public Set<Item> getItems() {
		return items;
	}
	
	public void setItens(Set<Item> items) {
		this.items = items;
	}
	
	public int totalOpinions(){
		
		int total = 0;
		
		for(Item item :this.items)
			total +=item.totalOpinions();
		
		return total;
	}

}
