package com.champsoft.vrms2330241.modules.registration.application.service;

import com.champsoft.vrms2330241.modules.registration.application.exception.RegistrationNotFoundException;
import com.champsoft.vrms2330241.modules.registration.application.port.out.RegistrationRepositoryPort;
import com.champsoft.vrms2330241.modules.registration.domain.model.ExpiryDate;
import com.champsoft.vrms2330241.modules.registration.domain.model.Registration;
import com.champsoft.vrms2330241.modules.registration.domain.model.RegistrationId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistrationCrudService {

    private final RegistrationRepositoryPort repo;

    public RegistrationCrudService(RegistrationRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public Registration get(String id) {
        return repo.findById(new RegistrationId(id))
                .orElseThrow(() -> new RegistrationNotFoundException("Registration not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Registration> list() {
        return repo.findAll();
    }

    @Transactional
    public Registration renew(String id) {
        var reg = get(id);
        var nextExpiry = reg.expiry().value().plusYears(1);
        reg.renew(new ExpiryDate(nextExpiry));
        return repo.save(reg);
    }

    @Transactional
    public Registration cancel(String id) {
        var reg = get(id);
        reg.cancel();
        return repo.save(reg);
    }

    @Transactional
    public void delete(String id) {
        repo.deleteById(new RegistrationId(id));
    }
}
