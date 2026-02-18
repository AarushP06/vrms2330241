package com.champsoft.vrms2330241.modules.registration.infrastructure.acl;

import com.champsoft.vrms2330241.modules.owners.application.service.OwnerEligibilityService;
import com.champsoft.vrms2330241.modules.registration.application.port.out.OwnerEligibilityPort;
import org.springframework.stereotype.Component;

@Component
public class OwnerEligibilityAdapter implements OwnerEligibilityPort {

    private final OwnerEligibilityService ownersEligibility;

    public OwnerEligibilityAdapter(OwnerEligibilityService ownersEligibility) {
        this.ownersEligibility = ownersEligibility;
    }

    @Override
    public boolean isEligible(String ownerId) {
        return ownersEligibility.isEligible(ownerId);
    }
}
