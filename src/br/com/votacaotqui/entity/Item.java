package br.com.votacaotqui.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Item extends AbstractEntity {

	
	private String name;
	private String description;
	
	@OneToMany(mappedBy="item", fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Opinion> opinions;
	
	@ManyToOne(fetch = FetchType.EAGER)  
    @JoinColumn(name = "poll_id", insertable = true, updatable = true)  
    @Fetch(FetchMode.JOIN)  
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Poll poll;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Poll getPoll() {
		return poll;
	}
	
	public void setPoll(Poll poll) {
		this.poll = poll;
	}
	
	public Set<Opinion> getOpinions() {
		return opinions;
	}
	
	public void setOpinions(Set<Opinion> opinions) {
		this.opinions = opinions;
	}
	
	public int totalOpinions(){
		return this.opinions.size();
	}
}
