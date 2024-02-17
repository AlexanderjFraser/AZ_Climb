package alexander.az_climb;

import alexander.az_climb.block.ModBlocks;
import alexander.az_climb.block.MyBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alexander.az_climb.block_entity.MyBlockEntity;

import static alexander.az_climb.block.ModItemGroups.FUNCTIONAL_GROUP;

public class AZ_Climb implements ModInitializer {
	public static final String MOD_ID = "az_climb";
    public static final Logger LOGGER = LogManager.getLogger("az_climb");

	public static final Block MY_BLOCK = new MyBlock(FabricBlockSettings.of(Material.GLASS));
	public static BlockEntityType<MyBlockEntity> MY_BLOCK_ENTITY_TYPE;

	@Override
	public void onInitialize() {

		ModBlocks.registerBlocks();

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "my_block"), MY_BLOCK);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "checkpoint_block"),
				new BlockItem(MY_BLOCK, new Item.Settings().group(FUNCTIONAL_GROUP)));


		MY_BLOCK_ENTITY_TYPE = Registry.register(
				Registry.BLOCK_ENTITY_TYPE,
				new Identifier(MOD_ID, "my_block_entity"),
				BlockEntityType.Builder.create(MyBlockEntity::new, MY_BLOCK).build(null)
		);


	}
}