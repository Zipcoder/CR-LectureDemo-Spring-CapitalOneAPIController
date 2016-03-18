package Partayyy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class Authenticate {
    public static boolean authenticate(String userName){
        @Bean
        public CommandLineRunner authenticate(AccountDatabase database){
            return (args) -> {
                database.findByUserName(userName);
            };
        }
    }

}
