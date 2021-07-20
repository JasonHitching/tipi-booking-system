package com.example.tipi_stock.backend.structures;

import androidx.annotation.NonNull;

import java.util.Arrays;

/**
 * Class for modelling a Tipi structure
 */
public class Tipi {

    private final int legQuantity;
    private final int mediumGroundStakeQuantity;
    private final int largeGroundStakeQuantity;
    private final int fairyLightQuantity;
    private final int clevisPinsQuantity;
    private final String[] components;

    public Tipi() {
        components = new String[]{"Canvas", "8m Legs", "Ground Stakes", "Fairy Lights",
                "Chandelier", "Carpet Flooring", "Blanking Panels"};
        legQuantity = 8;
        mediumGroundStakeQuantity = 10;
        largeGroundStakeQuantity= 8;
        fairyLightQuantity = 5;
        clevisPinsQuantity = 20;
    }

    /**
     * Leg quantity accessor
     * @return leg quantity per Tipi
     */
    public int getLegQuantity() {
        return legQuantity;
    }

    /**
     * Medium ground stake quantity accessor
     * @return medium ground stake quantity per Tipi
     */
    public int getMediumGroundStakeQuantity() {
        return mediumGroundStakeQuantity;
    }

    /**
     * Large ground stake quantity accessor
     * @return large ground stake quantity per Tipi
     */
    public int getLargeGroundStakeQuantity() {
        return largeGroundStakeQuantity;
    }

    /**
     * Fairy light quantity accessor
     * @return fairy light quantity per Tipi
     */
    public int getFairyLightQuantity() {
        return fairyLightQuantity;
    }

    /**
     * Clevis pin quantity accessor
     * @return clevis pin quantity per Tipi
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
     * Overridden toString method, returning a string
     * representation of the class instance fields
     * @return string representation of class
     */
    @NonNull
    @Override
    public String toString() {
        return "Tipi{" +
                "legQuantity=" + legQuantity +
                ", mediumGroundStakeQuantity=" + mediumGroundStakeQuantity +
                ", largeGroundStakeQuantity=" + largeGroundStakeQuantity +
                ", fairyLightQuantity=" + fairyLightQuantity +
                ", clevisPinsQuantity=" + clevisPinsQuantity +
                ", components=" + Arrays.toString(components) +
                '}';
    }
}
