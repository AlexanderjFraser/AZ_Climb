package alexander.az_climb.block;

import alexander.az_climb.block_entity.MyBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.BlockView;

public class MyBlock extends BlockWithEntity {
    public MyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new MyBlockEntity();
    }
}
