package com.champsoft.vrms2330241.modules.cars.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataVehicleRepository extends JpaRepository<VehicleJpaEntity, String> {
    Optional<VehicleJpaEntity> findByVin(String vin);
    boolean existsByVin(String vin);
}
