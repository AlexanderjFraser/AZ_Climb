package alexander.az_climb.block_entity;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

import static alexander.az_climb.AZ_Climb.MOD_ID;
import static alexander.az_climb.block.ModBlocks.END_BLOCK;

public class ModBlockEntities {
    public static BlockEntityType<CustomBlockEntity> END_BLOCK_ENTITY;

    public static void registerAll() {
        BlockEntityType<CustomBlockEntity> END_BLOCK_ENTITY = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MOD_ID, "end_block_entity"),
                BlockEntityType.Builder.create(CustomBlockEntity::new, END_BLOCK).build(null)
        );
    }
}
