package alexander.az_climb.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StartBlock extends Block {
    // Static variable to store the start time
    public static long startTime = 0;
    public static long lastInBlockTime = 0;
    public static Map<UUID, Long> lastInBlockTimePerPlayer = new HashMap<>();

    public StartBlock() {
        super(FabricBlockSettings.of(Material.GLASS)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
                .noCollision()
                .luminance(15)
        );
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            // Update the last tick time for this player
            lastInBlockTimePerPlayer.put(player.getUuid(), world.getTime());

            startTime = 0;  // This line resets the timer display to 0.00 whenever the player enters/re-enters the StartBlock
        }
    }
}