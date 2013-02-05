package br.com.votacaotqui.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.votacaotqui.dao.PollDao;
import br.com.votacaotqui.entity.Item;
import br.com.votacaotqui.entity.Poll;

@Component
public class HibernatePollDao implements PollDao {
	
	
	private final Session session;
	
	public HibernatePollDao(Session session) {
		this.session = session;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.votacaotqui.dao.TesteDao#getAllTeste()
	 */
	public Poll getActivePoll(){
		
		Criteria criteria = session.createCriteria(Poll.class);
		
		return (Poll)criteria.list().get(0);
	}


	public Item getItemById(Long id) {
		
		Criteria  criteria = session.createCriteria(Item.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Item)criteria.uniqueResult();
	}

}
