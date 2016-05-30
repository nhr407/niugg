package net.ngg.example.service.alert;

import net.ngg.example.entity.exercise.Employee;

/**
 * 简便起见，将消息消费者也放到了同一个工程下
 * 正常情况下，应该是在另一个java web工程下
 */

public interface MailReceiveService {
	void receiveMail();
}
