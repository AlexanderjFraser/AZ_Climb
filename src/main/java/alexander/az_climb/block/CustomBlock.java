package alexander.az_climb.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class CustomBlock extends Block {
    public CustomBlock(Settings settings) {
        super(FabricBlockSettings.of(Material.STONE) // Choose a suitable material, GLASS for translucency
                .strength(0.5f) // Optional: Set hardness if needed
                .sounds(BlockSoundGroup.STONE) // Sound group for glass
        );
    }
}
