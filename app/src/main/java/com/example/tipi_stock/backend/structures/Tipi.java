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

    public int getLegQuantity() {
        return legQuantity;
    }

    public int getMediumGroundStakeQuantity() {
        return mediumGroundStakeQuantity;
    }

    public int getLargeGroundStakeQuantity() {
        return largeGroundStakeQuantity;
    }

    public int getFairyLightQuantity() {
        return fairyLightQuantity;
    }

    public int getClevisPinsQuantity() {
        return clevisPinsQuantity;
    }

    public String[] getComponents() {
        return components;
    }

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
