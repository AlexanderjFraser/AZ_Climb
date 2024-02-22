package alexander.az_climb;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.MinecraftServer;
import alexander.az_climb.block.StartBlock;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;

import java.util.UUID;

public class TickHandler {

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(TickHandler::checkPlayerLeftStartBlock);
    }

    private static void checkPlayerLeftStartBlock(MinecraftServer server) {
        // Assuming you have a way to identify the specific player in a singleplayer game
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            UUID playerUUID = client.player.getUuid();
            World world = client.world;

            // Directly check if the player has left the block since the last tick
            if (StartBlock.lastInBlockTimePerPlayer.containsKey(playerUUID)) {
                long lastTime = StartBlock.lastInBlockTimePerPlayer.get(playerUUID);
                long currentTime = world.getTime();

                // Instead of waiting for a full second, check if there's been no update in the current tick
                if (currentTime > lastTime) {
                    // Player has left the block, update the timer immediately
                    StartBlock.startTime = lastTime; // Use the last time the player was in the block as the start
                    StartBlock.lastInBlockTimePerPlayer.remove(playerUUID); // Remove the player from tracking

                    // Notify the player or take other actions as needed
                    client.player.sendMessage(new LiteralText("Timer started!"), true);
                }
            }
        }
    }
}

