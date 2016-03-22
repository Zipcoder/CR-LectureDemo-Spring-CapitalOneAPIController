package PCard.Controllers;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


@RestController
public class CapitalOneAPIController {
    private static String getUrlSource(String url) throws IOException {
        URL theURL = new URL(url);
        URLConnection urlC = theURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlC.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();
        return a.toString();
    }

    @RequestMapping("/accounts")
    @ResponseBody
    public static String checkAccount(@RequestParam(value = "accountnumber", defaultValue = "") String accountNumber) throws IOException {
        if (!accountNumber.isEmpty()) {
            try {
                return getUrlSource("http://api.reimaginebanking.com/accounts/" + accountNumber + "?key=ecd5230e89ef13d82854f5ad81b7e2db");
            } catch (Exception e) {
                return "0";
            }
        }
        else {
            return getUrlSource("http://api.reimaginebanking.com/accounts?key=ecd5230e89ef13d82854f5ad81b7e2db");
        }
    }

    @RequestMapping("/balance")
    @ResponseBody
    public static double checkBalance(@RequestParam(value = "accountnumber", defaultValue = "") String accountNumber) throws IOException {
        try {
            String source = getUrlSource("http://api.reimaginebanking.com/enterprise/accounts/" + accountNumber + "?key=ecd5230e89ef13d82854f5ad81b7e2db");
            return Double.valueOf(source.split("balance\": ")[1].split(", ")[0]);
        } catch (Exception e) {
            return 0.0;
        }
    }


}
