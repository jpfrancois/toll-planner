package com.tollplanner.enums;

/**
 * @author pablo
 */
public enum VehicleType {

    ALL("T"),
    CARS("A"),
    BUSES("B"),
    TRUCKS("C"),
    MOTORCYCLE("1"),
    CAR("2"),
    CAR_TRAILER_1_AXLE("3"),
    CAR_TRAILER_2_AXLE("4"),
    PICK_UP("5"),
    BUS_2_AXLE("6"),
    BUS_3_AXLE("7"),
    BUS_4_AXLE("8"),
    TRUCK_2_AXLE("9"),
    TRUCK_3_AXLE("10"),
    TRUCK_4_AXLE("11"),
    TRUCK_5_AXLE("12"),
    TRUCK_6_AXLE("13"),
    TRUCK_7_AXLE("14"),
    TRUCK_8_AXLE("15"),
    TRUCK_9_AXLE("16");

    private final String code;

    VehicleType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
