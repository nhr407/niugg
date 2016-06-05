package net.ngg.example.service.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
//@SOAPBinding(style = Style.RPC)
public interface HelloService {
	@WebMethod public String sayHello(String name);
	@WebMethod public int addNumbers(int a, int b);
	@WebMethod public double divideNumbers(int dividend, int divisor) throws DivideNumbersException;
}
