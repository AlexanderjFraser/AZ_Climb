package alexander.az_climb.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static alexander.az_climb.AZ_Climb.MOD_ID;
import static alexander.az_climb.block.ModItemGroups.BLOCK_GROUP;
import static alexander.az_climb.block.ModItemGroups.FUNCTIONAL_GROUP;

public class ModBlocks {

    public static final Block TEST_BLOCK = new CustomBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block START_BLOCK = new TranslucentNonCollidableBlock();
    public static final Block END_BLOCK = new TranslucentNonCollidableBlock();

    public static final Block DEATH_BLOCK_CLEAR = new TranslucentNonCollidableBlock();
    public static final Block DEATH_BLOCK_SOLID = new CustomBlock(FabricBlockSettings.of(Material.STONE).luminance(15));

    public static final Block CHECKPOINT_BLOCK = new TranslucentNonCollidableBlock();
    public static final Block CP_BLOCK2 = new TranslucentNonCollidableBlock();

    public static void registerBlocks() {
        // Block registration
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "test_block"), TEST_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "start_block"), START_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "end_block"), END_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "checkpoint_block"), CHECKPOINT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "death_block_clear"), DEATH_BLOCK_CLEAR);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "death_block_solid"), DEATH_BLOCK_SOLID);


        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cp_block2"), CP_BLOCK2);

        // Item registration for the block
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "test_block"),
                new BlockItem(TEST_BLOCK, new Item.Settings().group(BLOCK_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "start_block"),
                new BlockItem(START_BLOCK, new Item.Settings().group(FUNCTIONAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "end_block"),
                new BlockItem(END_BLOCK, new Item.Settings().group(FUNCTIONAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "checkpoint_block"),
                new BlockItem(CHECKPOINT_BLOCK, new Item.Settings().group(FUNCTIONAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "death_block_clear"),
                new BlockItem(DEATH_BLOCK_CLEAR, new Item.Settings().group(FUNCTIONAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "death_block_solid"),
                new BlockItem(DEATH_BLOCK_SOLID, new Item.Settings().group(FUNCTIONAL_GROUP)));



        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cp_block2"),
                new BlockItem(CP_BLOCK2, new Item.Settings().group(FUNCTIONAL_GROUP)));





    }




}
