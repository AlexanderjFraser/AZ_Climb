package alexander.az_climb;

import alexander.az_climb.block.ModBlocks;
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


public class AZ_Climb implements ModInitializer {
	public static final String MOD_ID = "az_climb";
    public static final Logger LOGGER = LogManager.getLogger("az_climb");


	@Override
	public void onInitialize() {

		ModBlocks.registerBlocks();



	}
}