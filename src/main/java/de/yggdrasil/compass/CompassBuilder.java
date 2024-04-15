package de.yggdrasil.compass;


import org.jetbrains.annotations.Nullable;

import java.util.Set;


/**
 * Builder for {@link Compass}
 */
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

    /**
     * Add item to {@link Compass}
     * @param item item to add
     * @param slot where to put
     */
    public void AddItem(CompassItem item, int slot) {
        items.add(new PositionedCompassItem(item, slot));
    }

    /**
     * Add item to {@link Compass}
     * @param item item to add
     */
    public void AddItem(PositionedCompassItem item) {
        items.add(item);
    }

    /**
     * Sets title of the {@link Compass}
     * @param title title to set
     */
    public void SetTitle(String title) {
        this.title = title;
    }

    /**
     * Sets size of the compass inventory
     * @param size size to set
     */
    public void SetSize(CompassSize size) {
        this.size = size;
    }

    /**
     * Tries to build a compass
     * @return  null if no title, size or items
     */
    public @Nullable Compass Build() {
        if(items.isEmpty() || title == null || size == null)
            return null;
        return new CompassImpl(size, title, items);
    }
}
