package com.example.algamoney.api.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
//import java.util.Arrays;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;


@Component
public class Mailer {

	@Autowired
	private  JavaMailSender mailsender;
	
//	@EventListener
//	private void teste(ApplicationReadyEvent event) {
//		this.enviarEmail("testes.algaworks@gmail.com", 
//				Arrays.asList("joaoquatlo@gmail.com"), 
//				"Teste de envio de email", 
//				"Olá<br/>Teste ok.");
//		System.out.println("Enviado com sucesso!");
//	}
	
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
