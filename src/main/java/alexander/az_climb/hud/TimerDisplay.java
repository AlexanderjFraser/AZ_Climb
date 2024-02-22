package alexander.az_climb.hud;

import alexander.az_climb.block.StartBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;

public class TimerDisplay implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register the HUD render callback
        HudRenderCallback.EVENT.register((MatrixStack matrixStack, float tickDelta) -> {
            renderTimer(matrixStack);
        });
    }

    private void renderTimer(MatrixStack matrixStack) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null && client.currentScreen == null) {
            World world = client.world;

            String message;
            if (StartBlock.startTime == 0) {
                message = "Timer: 0.00 seconds";  // Display this when the player is in the StartBlock
            } else {
                long currentTime = world.getTime();
                long elapsedTicks = currentTime - StartBlock.startTime;
                double elapsedSeconds = elapsedTicks / 20.0; // Convert ticks to seconds
                message = String.format("Timer: %.2f seconds", elapsedSeconds);
            }

            int color = 0xFFFFFF; // White color
            int screenWidth = client.getWindow().getScaledWidth();
            int screenHeight = client.getWindow().getScaledHeight();
            int textWidth = client.textRenderer.getWidth(message);
            int x = (screenWidth - textWidth) / 2;
            int y = screenHeight - 59; // Position above the hotbar

            client.textRenderer.draw(matrixStack, new LiteralText(message), x, y, color);
        }
    }
}
