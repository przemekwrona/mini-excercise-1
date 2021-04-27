package pl.edu.pw.mini.wronadb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pw.mini.wronadb.customers.CustomerService;
import pl.edu.pw.mini.wronadb.generator.NameGenerator;
import pl.edu.pw.mini.wronadb.model.Customer;
import pl.edu.pw.mini.wronadb.request.UpdateCustomerRequest;

import java.util.List;

@Slf4j
@SpringBootApplication
public class WronaDbApplication implements CommandLineRunner {

    private final CustomerService customerService;

    public WronaDbApplication(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WronaDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerService.findCustomerById("ANATR");
        log.info("Customer with id ALFKI {}", customer);

        List<Customer> customers = customerService.findTop10Customers();
        customers.forEach(top10Customer -> log.info("Top 10 Customer {}", top10Customer));

        // delete customer
        String removeCustomerId = "ALFKI";
        log.info("Remove user with id {}", removeCustomerId);
        customerService.deleteCustomerById(removeCustomerId);

        //update customer
        // Alfreds Futterkiste
        UpdateCustomerRequest updateCustomerRequest = UpdateCustomerRequest.builder()
                .customerId("ALFKI")
                .companyName("Alfreds Factory")
                .build();

        log.info("Update customer with id {} with values {}", "ALFKI", updateCustomerRequest);

        Customer updatedCustoer = customerService.updateCustomer(updateCustomerRequest);

        log.info("Updated customer {}", updatedCustoer);

        log.info("Generated name {}", NameGenerator.getRandomName());
        log.info("Generated name {}", NameGenerator.getRandomName());
        log.info("Generated name {}", NameGenerator.getRandomName());

    }
}
