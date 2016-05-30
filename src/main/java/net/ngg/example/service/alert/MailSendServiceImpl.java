package net.ngg.example.service.alert;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import net.ngg.example.entity.exercise.Employee;

@Component
public class MailSendServiceImpl implements MailSendService {

	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMail(final Employee employee) {
		jmsTemplate.send(
				"spitter.queue", 
				new MessageCreator(){
					public Message createMessage(Session session) throws JMSException {
						MapMessage message = session.createMapMessage();
						message.setString("username", employee.getFirstname()+employee.getLastname());
						message.setInt("userid", employee.getId());
						message.setString("email", employee.getEmail());
						return message;
					}
		});
	}
	
}
