package br.com.votacaotqui.dao;

import br.com.votacaotqui.entity.Item;
import br.com.votacaotqui.entity.Poll;

public interface PollDao {

	public abstract Poll getActivePoll();
	
	public abstract Item getItemById(Long id);

}