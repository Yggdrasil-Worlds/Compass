package de.yggdrasil.compass;

import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;

/**
 * Size of a {@link Compass}. Wrapper for {@link InventoryType]
 */
public enum CompassSize {
    ROW_1(InventoryType.CHEST_1_ROW),
    ROW_2(InventoryType.CHEST_2_ROW),
    ROW_3(InventoryType.CHEST_3_ROW),
    ROW_4(InventoryType.CHEST_4_ROW),
    ROW_5(InventoryType.CHEST_5_ROW),
    ROW_6(InventoryType.CHEST_6_ROW);

    CompassSize(InventoryType type) {
        Type = type;
    }
    public final InventoryType Type;
    public static CompassSize valueOf(InventoryType type) {
        switch (type) {
            case CHEST_1_ROW -> {
                return CompassSize.ROW_1;
            }
            case CHEST_2_ROW -> {
                return CompassSize.ROW_2;
            }
            case CHEST_3_ROW -> {
                return CompassSize.ROW_3;
            }
            case CHEST_4_ROW -> {
                return CompassSize.ROW_4;
            }case CHEST_5_ROW -> {
                return CompassSize.ROW_5;
            }case CHEST_6_ROW -> {
                return CompassSize.ROW_6;
            }
            default -> {
                throw new IllegalArgumentException("Invalid argument provided: " + type);
            }
        }
    }
}
