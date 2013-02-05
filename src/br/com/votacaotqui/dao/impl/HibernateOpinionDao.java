package br.com.votacaotqui.dao.impl;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.vraptor.ioc.Component;
import br.com.votacaotqui.dao.OpinionDao;
import br.com.votacaotqui.entity.Opinion;

@Component
public class HibernateOpinionDao implements OpinionDao {
	
	
	private final Session session;
	
	public HibernateOpinionDao(Session session) {
		this.session = session;
	}

	
	@Transactional
	public Opinion save(Opinion opinion) {
		
		session.save(opinion);
		
		
		return opinion;
		
	}
	
	
	

}
