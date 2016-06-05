package net.ngg.example.service.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Service Implementation
 * Web Service End-point implementation class
 */
@WebService(endpointInterface = "net.ngg.example.ws.HelloService")
public class HelloServiceImpl implements HelloService{
	public HelloServiceImpl() {}
	
	@Override
	public String sayHello(String name) {
		return "Hello, " + name +".";
	}
	
	@Override
	public int addNumbers(int a, int b) {
		return a + b;
	}
	
	@Override
	public double divideNumbers(int dividend, int divisor) throws DivideNumbersException{
		if (divisor == 0) {
	         throw new DivideNumbersException("Divisor cannot be zero!");
	    }
	    return (double)dividend/divisor;
	}
}
