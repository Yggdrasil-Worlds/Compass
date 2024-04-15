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
}
