package com.tollplanner.enums;

/**
 * @author pablo
 */
public enum NetworkType {

    SIMPLIFIED("simplificada"),
    DETAILED("detallada");

    private final String code;

    NetworkType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
