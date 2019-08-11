package pl.piomin.microservices.order.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OrderNotFoundException(String pesel) {
		super("No such order: " + pesel);
	}
	
}
