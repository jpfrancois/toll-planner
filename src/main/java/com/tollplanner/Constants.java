package com.tollplanner;

/**
 * @author pablo
 */
public final class Constants {

    public static final String SERVICE_URL = "http://aplicaciones4.sct.gob.mx/sibuac_internet/ControllerUI";
    public static final String SERVICE_CMD = "cmdSolRutas";
    public static final String SERVICE_TYPE = "1";

    public static final String ORIGIN_STATE = "edoOrigen";
    public static final String DESTINATION_STATE = "edoDestino";
    public static final String ORIGIN_CITY = "ciudadOrigen";
    public static final String DESTINATION_CITY = "ciudadDestino";

    public static final String VEHICLES = "vehiculos";
    public static final String NETWORK = "red";

    public static final String ACTION = "action";
    public static final String TYPE = "tipo";

    public static final String JSON_STATES = "estados";
    public static final String JSON_LOCALITIES = "puntos";
    public static final String JSON_LOCALITY_NAME = "nombre";
    public static final String JSON_STATE_CODE = "estado";

    private Constants() {
        // Should not be instantiated
    }

}
