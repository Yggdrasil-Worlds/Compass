package de.yggdrasil.compass;

import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompassBuilderTest {

    @Test
    void test() {
        CompassBuilder builder = new CompassBuilder();
        builder.SetTitle("Test Compass");
        builder.SetSize(CompassSize.ROW_2);
        builder.AddItem(new CompassItem() {
            @Override
            public void OnClicked(@NotNull Player player) {
            }

            @Override
            public ItemStack Representation() {
                return ItemStack.AIR;
            }
        }, 1);
        Compass compass = builder.Build();
        assert compass != null;
        assert compass.getSize() == CompassSize.ROW_2;
        assert compass.getTitle().equals(Component.text("Test Compass"));
    }

}