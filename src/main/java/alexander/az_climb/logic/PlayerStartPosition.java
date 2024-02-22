package alexander.az_climb.logic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class PlayerStartPosition {
    private final BlockPos position;
    private final Vec3d lookVector;

    public PlayerStartPosition(BlockPos position, Vec3d lookVector) {
        this.position = position;
        this.lookVector = lookVector;
    }

    public BlockPos getPosition() {
        return position;
    }

    public Vec3d getLookVector() {
        return lookVector;
    }
}

