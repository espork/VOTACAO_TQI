package br.com.votacaotqui.converter;

import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.votacaotqui.dao.PollDao;
import br.com.votacaotqui.entity.Item;


@Convert(Item.class)
@RequestScoped
public class ItemConverter implements Converter<Item> {

	private PollDao pollDao;
	
	public ItemConverter(PollDao pollDao){
		this.pollDao = pollDao;
	}
	
	public Item convert(String id, Class<? extends Item> type,
			ResourceBundle bundle) {
		
		
		if (id == null || id.equals("")) 
            return null;
        	
        return pollDao.getItemById(Long.valueOf(id));
            
       
	}

}
