package com.champsoft.vrms2330241.modules.registration.application.port.out;

import com.champsoft.vrms2330241.modules.registration.domain.model.Registration;
import com.champsoft.vrms2330241.modules.registration.domain.model.RegistrationId;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepositoryPort {
    Registration save(Registration registration);
    Optional<Registration> findById(RegistrationId id);
    List<Registration> findAll();
    void deleteById(RegistrationId id);
}
