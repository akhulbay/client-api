package kz.shyngys.client_api.service;

public interface AccountLimitService {

    void createDefault(Long accountId);

    void update(Long id, Double limit);

}
