package com.example.tipi_stock.backend.structures;

/**
 * Class for modelling a marquee object
 */
public class Marquee {

    private final int legQuantity;
    private final int mediumGroundStakeQuantity;
    private final int largeGroundStakeQuantity;
    private final int fairyLightQuantity;
    private final int clevisPinsQuantity;
    private final int centerLegQuantity;
    private final String[] components;

    public Marquee() {
        components = new String[]{"Canvas", "5m Outside Legs", "20m Center Legs", "Ground Stakes",
                "Fairy Lights", "Chandelier", "Carpet Flooring", "Blanking Panels"};
        legQuantity = 12;
        mediumGroundStakeQuantity = 10;
        largeGroundStakeQuantity= 8;
        centerLegQuantity = 4;
        fairyLightQuantity = 15;
        clevisPinsQuantity = 500;
    }

    /**
     * Leg quantity accessor
     * @return leg quantity per Marquee
     */
    public int getLegQuantity() {
        return legQuantity;
    }

    /**
     * Medium ground stake quantity accessor
     * @return medium ground stake quantity per Marquee
     */
    public int getMediumGroundStakeQuantity() {
        return mediumGroundStakeQuantity;
    }

    /**
     * Large ground stake quantity accessor
     * @return large ground stake quantity per Marquee
     */
    public int getLargeGroundStakeQuantity() {
        return largeGroundStakeQuantity;
    }

    /**
     * Fairy light quantity accessor
     * @return fairy light quantity per Marquee
     */
    public int getFairyLightQuantity() {
        return fairyLightQuantity;
    }

    /**
     * Clevis pin quantity accessor
     * @return clevis pin quantity per Marquee
     */
    public int getClevisPinsQuantity() {
        return clevisPinsQuantity;
    }

    /**
     * Components array accessor
     * @return components array
     */
    public String[] getComponents() {
        return components;
    }

    /**
     * Center leg quantity accessor
     * @return center leg quantity per Marquee
     */
    public int getCenterLegQuantity() {
        return centerLegQuantity;
    }
}
