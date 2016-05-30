package net.ngg.example.service.alert;

import net.ngg.example.entity.exercise.Employee;

public interface MailSendService {
	void sendMail(Employee employee);
}
