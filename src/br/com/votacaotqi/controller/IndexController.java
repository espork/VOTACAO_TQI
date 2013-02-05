
package br.com.votacaotqi.controller;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.commons.lang.StringUtils;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votacaotqi.service.PollService;
import br.com.votacaotqui.dao.PollDao;
import br.com.votacaotqui.entity.Poll;

@Resource
public class IndexController {

	private final Result result;
	private PollDao pollDao;
	private HttpServletRequest request;
	private PollService pollService;
	private ServletContext context;
	
	public IndexController(Result result,PollDao pollDao,
						  HttpServletRequest request,PollService pollService,
						  ServletContext context) {
		
		this.pollDao = pollDao;
		this.result = result;
		this.request = request;
		this.pollService = pollService;
		this.context = context;
		
	}

	@Path("/")
	public void index() {
		
		this.changeLanguage(request.getParameter("language"));
		
		Poll poll = pollDao.getActivePoll();
		result.include("poll", poll);
		result.include("hideResultLink",pollService.resultUnavaliable(context, poll.totalOpinions()));
		
		
	}
	
	
	private void changeLanguage(String language){
		
		if(StringUtils.isNotEmpty(language)){
			
			Locale locale = new Locale(language);
	 
	        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
	        Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		}
	}
	
	

}
