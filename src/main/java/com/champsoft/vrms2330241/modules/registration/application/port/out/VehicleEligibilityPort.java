package com.champsoft.vrms2330241.modules.registration.application.port.out;

public interface VehicleEligibilityPort {
    boolean isEligible(String vehicleId);
}