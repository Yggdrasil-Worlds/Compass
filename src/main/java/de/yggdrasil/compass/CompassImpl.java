package de.yggdrasil.compass;

import net.kyori.adventure.text.Component;
import net.minestom.server.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Default implementation for the {@link Compass}
 */
public class CompassImpl implements Compass{
    private final Inventory inventory;
    public CompassImpl(CompassSize size, Component title, Set<PositionedCompassItem> items) {
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

    @Override
    public Component getTitle() {
        return inventory.getTitle();
    }

    @Override
    public @NotNull CompassSize getSize() {
        return CompassSize.valueOf(inventory.getInventoryType());
    }
}
