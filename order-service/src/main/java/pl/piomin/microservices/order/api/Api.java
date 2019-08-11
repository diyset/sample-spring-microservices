package pl.piomin.microservices.order.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.order.intercomm.AccountClient;
import pl.piomin.microservices.order.model.Account;
import pl.piomin.microservices.order.model.Customer;
import pl.piomin.microservices.order.model.CustomerType;
import pl.piomin.microservices.order.model.Order;

@RestController
public class Api {
	
	@Autowired
	private AccountClient accountClient;
	
	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	private List<Order> orders;
	
	public Api() {
		orders = new ArrayList<>();
		int i = 0;
		orders.add(new Order(i++, 50000));
		orders.add(new Order(i++, 80000));
		orders.add(new Order(i++, 60000));
		orders.add(new Order(i++, 70000));


	}
	
	@RequestMapping("/customers/pesel/{price}")
	public Order findByPesel(@PathVariable("price") String pesel) {
		logger.info(String.format("Customer.findByPesel(%s)", pesel));
		return orders.stream().filter(it -> (String.valueOf(it.getPrice()).equals(pesel))).findFirst().get();
	}
	
	@RequestMapping("/customers")
	public List<Order> findAll() {
		logger.info("Customer.findAll()");
		return orders;
	}
	
//	@RequestMapping("/customers/{id}")
//	public Customer findById(@PathVariable("id") Integer id) {
//		logger.info(String.format("Customer.findById(%s)", id));
//		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
//		List<Account> accounts =  accountClient.getAccounts(id);
//		customer.setAccounts(accounts);
//		return customer;
//	}
	
}
