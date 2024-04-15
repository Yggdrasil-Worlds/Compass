package de.yggdrasil.compass;

import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;


/**
 * An item which can be added to a {@link Compass}
 */
public interface CompassItem {
    void OnClicked(@NotNull Player player);
    ItemStack Representation();
}
