package net.ngg.example.service.alert;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component
public class MailReceiveServiceImpl implements MailReceiveService,MessageListener {

	@Override
	public void receiveMail() {
		
	}

	@Override
	public void onMessage(Message arg0) {
		
	}

}
