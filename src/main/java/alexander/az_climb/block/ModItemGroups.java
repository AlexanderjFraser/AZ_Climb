package alexander.az_climb.block;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static alexander.az_climb.block.ModBlocks.DEATH_BLOCK_SOLID;
import static alexander.az_climb.block.ModBlocks.TEST_BLOCK;

public class ModItemGroups {
    public static final ItemGroup BLOCK_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("az_climb", "block_group"))
            .icon(() -> new ItemStack(TEST_BLOCK)) // Specify an icon for the group
            .build();

    public static final ItemGroup FUNCTIONAL_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("az_climb", "functional_group"))
            .icon(() -> new ItemStack(DEATH_BLOCK_SOLID)) // Specify an icon for the group
            .build();
}
