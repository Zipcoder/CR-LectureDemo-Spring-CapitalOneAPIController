package Partayyy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class Authenticate {

    @Bean
    public CommandLineRunner authenticate(AccountDatabase database){
        return (args) -> {
            UserAccount user = database.findByUserName();
            if (user.getPassword().equals()) return true;
            else return false;
        };
    }
}
