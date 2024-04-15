package de.yggdrasil.compass;


import kotlin.collections.ArrayDeque;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Builder for {@link Compass}
 */
public class CompassBuilder {

    private List<PositionedCompassItem> items = null;
    private Component title = null;
    private CompassSize size = null;

    public CompassBuilder() {
        items = new ArrayList<>();
    }

    public CompassBuilder(Component title, CompassSize size) {
        this.title = title;
        this.size = size;
        items = new ArrayList<>();
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
        this.title = Component.text(title);
    }
    /**
     * Sets title of the {@link Compass}
     * @param title title to set
     */
    public void SetTitle(Component title) {
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
        return new CompassImpl(size, title, items.stream().collect(Collectors.toUnmodifiableSet()));
    }
}
