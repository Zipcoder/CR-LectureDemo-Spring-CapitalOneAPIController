package PCard.Domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountDatabase extends CrudRepository<UserAccount, Long> {

    UserAccount findByUserName(String userName);
    UserAccount findByEmail(String email);
    UserAccount findByAccountID(String accountID);
}