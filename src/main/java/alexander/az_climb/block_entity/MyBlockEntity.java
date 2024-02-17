package alexander.az_climb.block_entity;

import alexander.az_climb.AZ_Climb;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class MyBlockEntity extends BlockEntity {
    public MyBlockEntity(BlockPos pos, BlockState state) {
        super(AZ_Climb.MY_BLOCK_ENTITY_TYPE);
    }

    public MyBlockEntity() {
        super(AZ_Climb.MY_BLOCK_ENTITY_TYPE);
    }


    // Add any additional functionality your block entity needs here.
}