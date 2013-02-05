package br.com.votacaotqi.infra;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import net.vidageek.mirror.dsl.Mirror;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.proxy.SuperMethod;

@Component
public class SessionCreator implements ComponentFactory<Session> {
	
	private final SessionFactory factory;
	private final Proxifier proxifier;
	private Session session;
	
	public SessionCreator(SessionFactory factory,Proxifier proxifier) {
		this.proxifier = proxifier;
		this.factory = factory;
	}
	
	@PostConstruct
	public void abre() {
		
		this.session =  proxifier.proxify(Session.class, new MethodInvocation<Session>(){

			public Object intercept(Session proxy, Method method,Object[] args, SuperMethod superMethod) {
				
				Session sessionDoSpring = SessionFactoryUtils.doGetSession(factory, true);
				
				return new Mirror().on(sessionDoSpring).invoke().method(method).withArgs(args);
				
			}

			});
		
		
	}
	
	public Session getInstance() {
		return this.session;
	}
	
	@PreDestroy
	public void fecha() {
		this.session.close();
	}

}
