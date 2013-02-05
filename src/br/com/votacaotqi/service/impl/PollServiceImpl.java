package br.com.votacaotqi.service.impl;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.ioc.Component;
import br.com.votacaotqi.dto.ResultDTO;
import br.com.votacaotqi.service.PollService;
import br.com.votacaotqui.dao.PollDao;
import br.com.votacaotqui.entity.Item;
import br.com.votacaotqui.entity.Poll;

@Component
public class PollServiceImpl implements PollService {
	
	
	private PollDao pollDao;
	
	public PollServiceImpl(PollDao polldDao){
		
		this.pollDao = polldDao;
	}
	
	
	public ResultDTO getResultPoll(){
		
		Poll poll = pollDao.getActivePoll();
		
		ResultDTO resultDto = new ResultDTO(poll.totalOpinions());
		
		for(Item item :poll.getItems())
			resultDto.add(item);
		
		
		return resultDto;
		
	}


	public boolean resultUnavaliable(ServletContext context, int total) {
		int minOpinion = 0;
		try{
			minOpinion = Integer.valueOf(context.getInitParameter("MIN_VOTE"));
		}catch(NumberFormatException e){
			
			minOpinion =0;
			e.printStackTrace();
		}
		
		return total<minOpinion;
	}

}
