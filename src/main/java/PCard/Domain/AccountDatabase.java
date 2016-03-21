package Partayyy;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountDatabase extends CrudRepository<UserAccount, Long> {

    List<UserAccount> findByUserName(String userName);
    List<UserAccount> findByEmail(String email);
}