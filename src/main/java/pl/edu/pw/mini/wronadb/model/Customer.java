package pl.edu.pw.mini.wronadb.model;

import lombok.Setter;

@Setter
public class Customer {

    private String CustomerID;
    private String CompanyName;
    private String  ContactName;
    private String ContactTitle;
    private String Address;
    private String City;
    private String Region;
    private String PostalCode;
    private String Country;
    private String Phone;
    private String Fax;

    public Customer() {
    }

    @Override
    public String toString() {
        return String.format("Customer with id: %s, company name: %s, contact title: %s", CustomerID, CompanyName, ContactTitle);
    }


}
