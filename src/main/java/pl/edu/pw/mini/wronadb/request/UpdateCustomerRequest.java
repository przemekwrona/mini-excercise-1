package pl.edu.pw.mini.wronadb.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCustomerRequest {

    private String customerId;
    private String companyName;

    @Override
    public String toString() {
        return String.format("UpdateCustomerRequest with id: %s, company name: %s", customerId, companyName);
    }

}
