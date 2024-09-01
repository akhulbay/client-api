package kz.shyngys.client_api.repository;

import kz.shyngys.client_api.model.db.AccountLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLimitRepository extends JpaRepository<AccountLimit, Long> {
}
