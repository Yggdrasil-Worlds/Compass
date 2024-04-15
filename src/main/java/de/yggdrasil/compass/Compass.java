package de.yggdrasil.compass;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public interface Compass {
    Component getTitle();
    @NotNull CompassSize getSize();
}
