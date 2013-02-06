
package br.com.votacaotqi.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votacaotqi.service.LocaleService;
import br.com.votacaotqi.service.PollService;
import br.com.votacaotqui.dao.PollDao;
import br.com.votacaotqui.entity.Poll;

@Resource
public class IndexController {

	private final Result result;
	private PollDao pollDao;
	private PollService pollService;
	private ServletContext context;
	
	public IndexController(Result result,PollDao pollDao,
						  HttpServletRequest request,
						  PollService pollService,
						  ServletContext context,
						  LocaleService localeService) {
		
		this.pollDao = pollDao;
		this.result = result;
		this.pollService = pollService;
		this.context = context;
		
		localeService.changeLanguage(request.getParameter("language"));
		
	}

	@Path("/")
	public void index() {
		
		Poll poll = pollDao.getActivePoll();
		result.include("poll", poll);
		result.include("hideResultLink",pollService.resultUnavaliable(context, poll.totalOpinions()));
		
		
	}
	
	
	

}
