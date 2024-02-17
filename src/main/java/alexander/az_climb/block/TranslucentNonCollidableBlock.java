package alexander.az_climb.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class TranslucentNonCollidableBlock extends Block {
    public TranslucentNonCollidableBlock() {
        super(FabricBlockSettings.of(Material.GLASS) // Choose a suitable material, GLASS for translucency
                        .strength(0.5f) // Optional: Set hardness if needed
                        .sounds(BlockSoundGroup.GLASS) // Sound group for glass
                        .nonOpaque() // Make the block non-opaque
                        .noCollision() // Ensures the block does not have collision
                        .luminance(15)
        );
    }
}
