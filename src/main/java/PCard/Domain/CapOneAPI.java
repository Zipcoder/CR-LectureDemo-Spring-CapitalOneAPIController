package PCard.Domain;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.AccountNotFoundException;

/**
 * Created by rkelly on 3/15/16.
 */
@Service
public class CapOneAPI {

    protected RestTemplate restTemplate;

    protected String serviceUrl;
    private CapOneAPI() {

    }
    public CapOneAPI(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ?
                serviceUrl : "http://" + serviceUrl;
    }

    public UserAccount getByNumber(String accountNumber) throws AccountNotFoundException {
        UserAccount account = restTemplate.getForObject(serviceUrl
                + "/accounts/{number}", UserAccount.class, accountNumber);

        if (account == null)
            throw new AccountNotFoundException(accountNumber);
        else
            return account;
    }

}