package com.champsoft.vrms2330241.modules.registration.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRegistrationRepository extends JpaRepository<RegistrationJpaEntity, String> {
}
