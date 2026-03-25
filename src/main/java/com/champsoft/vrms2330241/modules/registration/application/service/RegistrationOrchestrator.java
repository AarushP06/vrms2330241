package com.champsoft.vrms2330241.modules.registration.application.service;

import com.champsoft.vrms2330241.modules.registration.application.port.out.RegistrationRepositoryPort;
import com.champsoft.vrms2330241.modules.registration.domain.exception.ExpiryDateMustBeFutureException;
import com.champsoft.vrms2330241.modules.registration.domain.exception.InvalidPlateException;
import com.champsoft.vrms2330241.modules.registration.domain.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class RegistrationOrchestrator {

    private final RegistrationRepositoryPort repo;

    public RegistrationOrchestrator(RegistrationRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional
    public Registration register(String vehicleId, String ownerId, String agentId) {
        var plateValue = "AUTO-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        var expiry = LocalDate.now().plusYears(1);

        if (plateValue.isBlank()) {
            throw new InvalidPlateException("Plate number is required");
        }
        if (!expiry.isAfter(LocalDate.now())) {
            throw new ExpiryDateMustBeFutureException("Expiry must be a future date");
        }

        var reg = new Registration(
                new RegistrationId(UUID.randomUUID().toString()),
                new VehicleRef(vehicleId),
                new OwnerRef(ownerId),
                new AgentRef(agentId),
                new PlateNumber(plateValue),
                new ExpiryDate(expiry),
                RegistrationStatus.ACTIVE
        );
        return repo.save(reg);
    }
}
