package br.com.votacaotqi.service;

import javax.servlet.ServletContext;

import br.com.votacaotqi.dto.ResultDTO;

public interface PollService {
	
	public abstract ResultDTO getResultPoll();
	public abstract boolean resultUnavaliable(ServletContext context,int total);
}
