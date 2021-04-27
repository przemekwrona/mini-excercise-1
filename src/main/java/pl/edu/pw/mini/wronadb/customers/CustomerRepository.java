package pl.edu.pw.mini.wronadb.customers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.edu.pw.mini.wronadb.DataSource;
import pl.edu.pw.mini.wronadb.model.Customer;
import pl.edu.pw.mini.wronadb.request.UpdateCustomerRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Repository
public class CustomerRepository {

    public Customer findCustomerById(String customerId) {

        Connection connection;
        Statement statement;

        try {
            connection = DataSource.getConnection();
            statement = connection.createStatement();

            ResultSet results = statement.executeQuery(String.format("SELECT * FROM Customers WHERE CustomerID = '%s'", customerId));
            results.next();

            Customer customer = buildCustomer(results);

            statement.close();
            connection.close();

            return customer;
        } catch (SQLException ex) {
        }

        return null;
    }

    private Customer buildCustomer(ResultSet results) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerID(results.getString("CustomerID"));
        customer.setCompanyName(results.getString("CompanyName"));
        customer.setContactName(results.getString("ContactName"));
        customer.setContactTitle(results.getString("ContactTitle"));
        return customer;
    }

    public List<Customer> findTop10Customers() {

        Connection connection;
        Statement statement;

        try {
            connection = DataSource.getConnection();
            statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT TOP(10) * FROM Customers");

            List<Customer> top10Customers = new LinkedList<>();
            while (results.next()) {
                Customer customer = buildCustomer(results);

                top10Customers.add(customer);
            }
            results.next();

            statement.close();
            connection.close();

            return top10Customers;
        } catch (SQLException ex) {
        }

        return List.of();
    }

    public void deleteCustomerById(String customerId) {
        Connection connection;
        Statement statement;

        try {
            connection = DataSource.getConnection();
            statement = connection.createStatement();

            statement.executeUpdate(String.format("DELETE FROM Customers WHERE CustomerId = '%s'", customerId));

            statement.close();
            connection.close();

        } catch (SQLException ex) {
        }

    }

    public void updateCustomer(UpdateCustomerRequest customer) {
        Connection connection;
        Statement statement;

        try {
            connection = DataSource.getConnection();
            statement = connection.createStatement();

            String sql = String.format("UPDATE Customers SET CompanyName = '%s' WHERE CustomerId = '%s'", customer.getCompanyName(), customer.getCustomerId());
            statement.executeUpdate(sql);

            statement.close();
            connection.close();

        } catch (SQLException ex) {
        }

    }
}
