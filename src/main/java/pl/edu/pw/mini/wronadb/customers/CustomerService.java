package pl.edu.pw.mini.wronadb.customers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pw.mini.wronadb.model.Customer;
import pl.edu.pw.mini.wronadb.request.UpdateCustomerRequest;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findCustomerById(String customerId) {
        return customerRepository.findCustomerById(customerId);
    }

    public List<Customer> findTop10Customers() {
        return customerRepository.findTop10Customers();
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteCustomerById(customerId);
    }

    public Customer updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        customerRepository.updateCustomer(updateCustomerRequest);
        return customerRepository.findCustomerById(updateCustomerRequest.getCustomerId());
    }
}
