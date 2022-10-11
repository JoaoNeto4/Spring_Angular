package com.example.algamoney.api.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Locale;
import java.util.Map;

//import com.example.algamoney.api.repository.LancamentoRepository;
//import java.util.Arrays;
//import java.util.HashMap;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import com.example.algamoney.api.model.Lancamento;

@Component
public class Mailer {

	@Autowired
	private  JavaMailSender mailsender;
	
	@Autowired
	private TemplateEngine thymeleaf;
	
//	@Autowired
//	private LancamentoRepository repo;
//	@EventListener
//	private void teste(ApplicationReadyEvent event) {
//		String template = "mail/aviso-lancamentos-vencidos";
//		
//		List<Lancamento> lista = repo.findAll();
//		
//		Map<String, Object> variaveis = new HashMap<>();
//		variaveis.put("lancamentos", lista);
//		
//		this.enviarEmail("testes.algaworks@gmail.com", 
//				Arrays.asList("joaoquatlo@gmail.com"), 
//				"Teste de envio de email", 
//				template, variaveis);
//		System.out.println("Enviado com sucesso!");
//	}
	
	public void enviarEmail(String remetente, List<String> destinatarios,
			String assunto, String template, 
			Map<String, Object> variaveis) {
		
		Context context = new Context(new Locale("pt","BR"));
		
		variaveis.entrySet().forEach(e -> context.setVariable(e.getKey(), e.getValue()));
		
		String mensagem = thymeleaf.process(template, context);
		this.enviarEmail(remetente, destinatarios, assunto, mensagem);
	}
	
	public void enviarEmail(String remetente, List<String> destinatarios,
			String assunto, String menssagem) {
		
		try {
			MimeMessage mimeMessage = mailsender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
			helper.setFrom(remetente);
			helper.setTo(destinatarios.toArray(new String[destinatarios.size()]));
			helper.setSubject(assunto);
			helper.setText(menssagem, true);
			
			mailsender.send(mimeMessage);
		} catch (MessagingException e) {
			throw new RuntimeException("Problemas com o envio de E-mail!",e);
		}
		
		
		
	}
}
