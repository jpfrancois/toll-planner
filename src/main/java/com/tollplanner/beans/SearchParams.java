package com.tollplanner.beans;

import com.tollplanner.enums.NetworkType;
import com.tollplanner.enums.VehicleType;

/**
 * @author pablo
 */
public class SearchParams {

    private String originState;
    private String destinationState;
    private String originCity;
    private String destinationCity;
    private VehicleType vehicleType;
    private NetworkType networkType;

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(final String originState) {
        this.originState = originState;
    }

    public String getDestinationState() {
        return destinationState;
    }

    public void setDestinationState(final String destinationState) {
        this.destinationState = destinationState;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(final String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(final String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(final VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public NetworkType getNetworkType() {
        return networkType;
    }

    public void setNetworkType(final NetworkType networkType) {
        this.networkType = networkType;
    }

}
