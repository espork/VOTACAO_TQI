
package br.com.votacaotqi.controller;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votacaotqi.dto.ResultDTO;
import br.com.votacaotqi.service.PollService;

@Resource
public class ResultController {

	private PollService pollService;
	private final Result result;
	private ServletContext context;
	
	public ResultController(PollService pollService,Result result,ServletContext context) {
		
		this.pollService = pollService;
		this.result = result;
		this.context = context;
	}

	
	public void index() {
		
		ResultDTO resultDto = pollService.getResultPoll();
		boolean resultUnavaliable = pollService.resultUnavaliable(context, resultDto.getTotal());
		
		if(resultUnavaliable)
			result.forwardTo(IndexController.class).index();
			
			
		result.include("result", pollService.getResultPoll());	
	}
	
	

}
