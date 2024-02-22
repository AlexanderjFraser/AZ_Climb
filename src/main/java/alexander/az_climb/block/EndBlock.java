package alexander.az_climb.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EndBlock extends Block {
    public EndBlock() {
        super(FabricBlockSettings.of(Material.GLASS)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
                .noCollision()
                .luminance(15)
        );
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity && StartBlock.startTime != 0) {
            long endTime = world.getTime();
            long elapsedTicks = endTime - StartBlock.startTime;
            // Reset the start time
            StartBlock.startTime = 0;
            // Convert ticks to seconds (20 ticks = 1 second) or adjust as needed
            double elapsedSeconds = elapsedTicks / 20.0;
            ((PlayerEntity) entity).sendMessage(new LiteralText("Timer stopped! Time: " + elapsedSeconds + " seconds."), true);
        }
    }
}

