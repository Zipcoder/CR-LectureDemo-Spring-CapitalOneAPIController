package PCard.Controllers;

import PCard.Domain.UrlSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@ComponentScan
@RestController
public class CapitalOneAPIController {
    @RequestMapping("/accounts")
    @ResponseBody
    public static String checkAccount(@RequestParam(value = "accountnumber", defaultValue = "") String accountNumber) throws IOException {
        if (!accountNumber.isEmpty()) {
            try {
                return UrlSource.getUrlSource("http://api.reimaginebanking.com/enterprise/accounts/" + accountNumber + "?key=ecd5230e89ef13d82854f5ad81b7e2db");
            } catch (Exception e) {
                return "None";
            }
        }
        else {
            return UrlSource.getUrlSource("http://api.reimaginebanking.com/enterprise/accounts?key=ecd5230e89ef13d82854f5ad81b7e2db");
        }
    }

    @RequestMapping("/balance")
    @ResponseBody
    public static long checkBalance(@RequestParam(value = "accountnumber", defaultValue = "") String accountNumber) throws IOException {
        try {
            String source = UrlSource.getUrlSource("http://api.reimaginebanking.com/enterprise/accounts/" + accountNumber + "?key=ecd5230e89ef13d82854f5ad81b7e2db");
            return Long.valueOf(source.split("balance\": ")[1].split(", ")[0]);
        } catch (Exception e) {
            return 0;
        }
    }
}
