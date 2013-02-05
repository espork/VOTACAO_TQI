package br.com.votacaotqui.entity;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

import nl.captcha.Captcha;

@Component
@RequestScoped
public class CaptchaEntity {

	private HttpServletRequest request;
	private HttpSession session;
	
	private Captcha captcha;
	private String answer;
	
	
	public CaptchaEntity(HttpServletRequest request,HttpSession session) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.captcha = (Captcha) session.getAttribute(Captcha.NAME);
	
	}
	
	public boolean isValid(){
		
		if(StringUtils.isEmpty(this.answer))
			return false;
		
		return this.captcha.isCorrect(this.answer);
		
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
