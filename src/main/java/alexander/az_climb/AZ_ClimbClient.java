package alexander.az_climb;

import alexander.az_climb.Screens.MainMenu;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AZ_ClimbClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Ensure the client is not null and the current screen is the TitleScreen
            if (client != null && client.currentScreen instanceof net.minecraft.client.gui.screen.TitleScreen) {
                // Ensure we are on the client thread when we try to open the screen
                if (client.isInSingleplayer() || client.getCurrentServerEntry() == null) {
                    client.execute(() -> {
                        client.openScreen(new MainMenu());
                    });
                }
            }
        });
    }
}

