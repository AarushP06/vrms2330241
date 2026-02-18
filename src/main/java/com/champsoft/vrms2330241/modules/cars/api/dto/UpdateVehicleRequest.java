package com.champsoft.vrms2330241.modules.cars.api.dto;


import jakarta.validation.constraints.*;

public record UpdateVehicleRequest(
        @NotBlank String make,
        @NotBlank String model,
        @Min(1980) @Max(2050) int year) {}
