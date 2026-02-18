package com.champsoft.vrms2330241.shared.web;

public record ApiErrorResponse(java.time.Instant now, int value, String message, String code, String requestURI) { }
