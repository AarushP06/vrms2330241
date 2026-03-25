package com.champsoft.vrms2330241.modules.registration.domain.model;

public class Registration {
    private final RegistrationId id;
    private final VehicleRef vehicle;
    private final OwnerRef owner;
    private final AgentRef agent;
    private final PlateNumber plate;
    private ExpiryDate expiry;
    private RegistrationStatus status;

    public Registration(
            RegistrationId id,
            VehicleRef vehicle,
            OwnerRef owner,
            AgentRef agent,
            PlateNumber plate,
            ExpiryDate expiry,
            RegistrationStatus status
    ) {
        this.id = id;
        this.vehicle = vehicle;
        this.owner = owner;
        this.agent = agent;
        this.plate = plate;
        this.expiry = expiry;
        this.status = status;
    }

    public RegistrationId id() {
        return id;
    }

    public VehicleRef vehicle() {
        return vehicle;
    }

    public OwnerRef owner() {
        return owner;
    }

    public AgentRef agent() {
        return agent;
    }

    public PlateNumber plate() {
        return plate;
    }

    public ExpiryDate expiry() {
        return expiry;
    }

    public RegistrationStatus status() {
        return status;
    }

    public void renew(ExpiryDate newExpiry) {
        this.expiry = newExpiry;
        this.status = RegistrationStatus.ACTIVE;
    }

    public void cancel() {
        this.status = RegistrationStatus.CANCELLED;
    }
}
