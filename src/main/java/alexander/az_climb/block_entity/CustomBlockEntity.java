package alexander.az_climb.block_entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import alexander.az_climb.AZ_Climb;


public class CustomBlockEntity extends BlockEntity {
    public CustomBlockEntity() {
        super(AZ_Climb.MY_BLOCK_ENTITY_TYPE);
    }

    public CustomBlockEntity(BlockPos pos, BlockState state) {
        super(AZ_Climb.MY_BLOCK_ENTITY_TYPE);
    }

}
