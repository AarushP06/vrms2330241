package com.champsoft.vrms2330241.modules.registration.infrastructure.persistence;

import com.champsoft.vrms2330241.modules.registration.application.port.out.RegistrationRepositoryPort;
import com.champsoft.vrms2330241.modules.registration.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaRegistrationRepositoryAdapter implements RegistrationRepositoryPort {
    private final SpringDataRegistrationRepository jpa;

    public JpaRegistrationRepositoryAdapter(SpringDataRegistrationRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Registration save(Registration registration) {
        var entity = toEntity(registration);
        jpa.save(entity);
        return registration;
    }

    @Override
    public Optional<Registration> findById(RegistrationId id) {
        return jpa.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Registration> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(RegistrationId id) {
        jpa.deleteById(id.value());
    }

    private RegistrationJpaEntity toEntity(Registration reg) {
        var entity = new RegistrationJpaEntity();
        entity.id = reg.id().value();
        entity.vehicleId = reg.vehicle().vehicleId();
        entity.ownerId = reg.owner().ownerId();
        entity.agentId = reg.agent().agentId();
        entity.plate = reg.plate().value();
        entity.expiry = reg.expiry().value();
        entity.status = reg.status().name();
        return entity;
    }

    private Registration toDomain(RegistrationJpaEntity entity) {
        return new Registration(
                new RegistrationId(entity.id),
                new VehicleRef(entity.vehicleId),
                new OwnerRef(entity.ownerId),
                new AgentRef(entity.agentId),
                new PlateNumber(entity.plate),
                new ExpiryDate(entity.expiry),
                RegistrationStatus.valueOf(entity.status)
        );
    }
}
