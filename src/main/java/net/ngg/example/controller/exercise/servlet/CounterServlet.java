package net.ngg.example.controller.exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
/**
 * 计数器servlet
 */
public class CounterServlet implements Servlet{
	
	private transient ServletConfig servletConfig;
	// 计数器
//	private volatile int count = 0;
	private int count = 0;
	
	public int getCount() {
		return count;
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return "My Servlet";
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
	}

	@Override
//	public synchronized void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		++count;
		String servletName = servletConfig.getServletName();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		Logger.getLogger(CounterServlet.class).log(Priority.INFO, Thread.currentThread().getName() + " counter=" + count);
		writer.print("<html><head></head><body>Hello from " + servletName + ". You're the " + count + " visitor.</body></html>");
	}

}
