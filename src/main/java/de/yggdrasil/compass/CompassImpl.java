package de.yggdrasil.compass;

import net.minestom.server.inventory.Inventory;

import java.util.Set;

public class CompassImpl implements Compass{
    private Inventory inventory;
    public CompassImpl(CompassSize size, String title, Set<PositionedCompassItem> items) {
        inventory = new Inventory(size.Type, title);
        items.forEach(item -> {
            inventory.setItemStack(item.Slot(), item.CompassItem().Representation());
            inventory.addInventoryCondition((player, slot, clickType, inventoryConditionResult) -> {
                if(slot != item.Slot())
                    return;
                item.CompassItem().OnClicked(player);
            });
        });

    }
}
