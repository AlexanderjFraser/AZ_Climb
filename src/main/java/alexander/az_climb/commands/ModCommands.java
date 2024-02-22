package alexander.az_climb.commands;

import alexander.az_climb.logic.PlayerStartPosition;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.math.Vec3d;

public class ModCommands {
    // Static variable to store the starting point
    private static BlockPos startingPoint = null;
    private static PlayerStartPosition localStartingPoint = null;

    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            setStartCommand(dispatcher);
            restartCommand(dispatcher);
            localrestartCommand(dispatcher);
        });
    }

    private static void setStartCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("setstart").executes(context -> {
            ServerCommandSource source = context.getSource();
            startingPoint = new BlockPos(source.getPosition());
            source.sendFeedback(new LiteralText("Starting point set!"), true);
            return 1; // Success
        }));
    }

    private static void restartCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("restart").executes(context -> {
            ServerCommandSource source = context.getSource();
            if (startingPoint != null) {
                source.getPlayer().teleport(source.getWorld(), startingPoint.getX() + 0.5, startingPoint.getY(), startingPoint.getZ() + 0.5, 0, 0);
                source.sendFeedback(new LiteralText("Teleported back to the starting point!"), true);
            } else {
                source.sendError(new LiteralText("Starting point not set!"));
            }
            return 1; // Success or failure
        }));
    }

    private static void localrestartCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("localrestart").executes(context -> {
            ServerCommandSource source = context.getSource();
            if (localStartingPoint != null) {
                BlockPos pos = localStartingPoint.getPosition();
                Vec3d lookVector = localStartingPoint.getLookVector();

                float yaw = (float) Math.toDegrees(Math.atan2(-lookVector.x, lookVector.z));
                float pitch = (float) Math.toDegrees(Math.asin(lookVector.y));

                source.getPlayer().teleport(
                        source.getWorld(),
                        pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, // Center the player on the block
                        yaw, pitch
                );
                source.sendFeedback(new LiteralText("Teleported back to the local starting point with orientation!"), true);
            } else {
                source.sendError(new LiteralText("Local starting point not set!"));
            }
            return 1; // Command execution success
        }));
    }

    public static void setLocalStartingPoint(BlockPos pos, Vec3d lookVector) {
        localStartingPoint = new PlayerStartPosition(pos, lookVector);
    }

    public static PlayerStartPosition getLocalStartingPoint() {
        return localStartingPoint;
    }
}
