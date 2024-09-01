package kz.shyngys.client_api.repository;

import kz.shyngys.client_api.model.db.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

