package de.yggdrasil.compass;

import net.minestom.server.inventory.InventoryType;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class CompassBuilder {

    private Set<PositionedCompassItem> items = null;
    private String title = null;
    private CompassSize size = null;

    public CompassBuilder() {
        items = Set.of();
    }

    public CompassBuilder(String title, CompassSize size) {
        this.title = title;
        this.size = size;
        items = Set.of();
    }

    public void AddItem(CompassItem item, int slot) {
        items.add(new PositionedCompassItem(item, slot));
    }
    public void AddItem(PositionedCompassItem item) {
        items.add(item);
    }

    public void SetTitle(String title) {
        this.title = title;
    }
    public void SetSize(CompassSize size) {
        this.size = size;
    }
    public @Nullable Compass Build() {
        if(items.isEmpty() || title == null || size == null)
            return null;
        return new CompassImpl(size, title, items);
    }
}
