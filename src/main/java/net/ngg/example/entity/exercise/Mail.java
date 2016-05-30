package net.ngg.example.entity.exercise;
/**
 * 邮件类，用于在增加了一个新的用户后，发送异步消息给邮件系统，
 * 邮件系统接收到消息后，发送邮箱确认核实邮件到用户邮箱
 *
 */
public class Mail {
	private String username;    // 注册用户名
	private Integer userid;           // 注册用户ID
	private String toAddress;  // 邮件接收者
	
	public Mail(){}
	
	public Mail(String username, Integer userid, String toAddress) {
		this.username = username;
		this.userid = userid;
		this.toAddress = toAddress;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
}
