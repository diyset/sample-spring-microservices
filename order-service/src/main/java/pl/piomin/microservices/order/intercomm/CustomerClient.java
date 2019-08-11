package pl.piomin.microservices.order.intercomm;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.piomin.microservices.order.model.Customer;

import java.util.List;

@FeignClient("customer-service")
public interface CustomerClient {

    @RequestMapping(method = RequestMethod.GET, value="/customers/{id}")
    List<Customer> getCustomers(@PathVariable("id") Integer id);
}
