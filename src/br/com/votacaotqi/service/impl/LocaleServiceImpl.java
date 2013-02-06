package br.com.votacaotqi.service.impl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.commons.lang.StringUtils;

import br.com.caelum.vraptor.ioc.Component;
import br.com.votacaotqi.service.LocaleService;

@Component
public class LocaleServiceImpl implements LocaleService {
	
	
	HttpServletRequest request;
	
	public LocaleServiceImpl(HttpServletRequest request){
		
		this.request = request;
	}

	public void changeLanguage(String language) {
		
		if(StringUtils.isNotEmpty(language)){
			
			Locale locale = new Locale(language);
	 
	        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
	        Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		}
		
	}
	
	
	

}
