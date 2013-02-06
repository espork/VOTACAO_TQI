
package br.com.votacaotqi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.votacaotqi.dto.OpinitonDTO;
import br.com.votacaotqui.dao.OpinionDao;
import br.com.votacaotqui.entity.CaptchaEntity;

@Resource
public class OpinionController {

	private final Result result;
	
	@Autowired
	private OpinionDao opinionDao;
	private HttpServletRequest request;
	private CaptchaEntity captcha;
	private Validator validator;
	
	public OpinionController(Result result,OpinionDao opinionDao,HttpServletRequest request, CaptchaEntity captcha,Validator validator) {
		
		this.opinionDao = opinionDao;
		this.result = result;
		this.request = request;
		this.captcha = captcha;
		this.validator = validator;
	}

	
	@Post
	public void say(final OpinitonDTO opinion ) {
		
		this.captcha.setAnswer(opinion.getAnswer());
		
		if (opinion.getItem() == null)
	        validator.add(new ValidationMessage("item.empty", "erro"));
		
		if(!captcha.isValid())
			validator.add(new ValidationMessage("captcha.invalid", "erro"));
	    

	    validator.onErrorForwardTo(IndexController.class).index();
		
		opinion.setIp(request.getRemoteHost());
		
		this.opinionDao.save(opinion.toEntity());
		
		result.include("message","poll.sucess");
		
		result.forwardTo(ResultController.class).index();
		
		
	}
	
	

}
