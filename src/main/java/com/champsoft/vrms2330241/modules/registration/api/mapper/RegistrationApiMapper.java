package com.champsoft.vrms2330241.modules.registration.api.mapper;

import com.champsoft.vrms2330241.modules.registration.api.dto.RegistrationResponse;
import com.champsoft.vrms2330241.modules.registration.domain.model.Registration;

public class RegistrationApiMapper {
    public static RegistrationResponse toResponse(Registration registration) {
        return new RegistrationResponse(
                registration.id().value(),
                registration.plate().value(),
                registration.status().name()
        );
    }
}
