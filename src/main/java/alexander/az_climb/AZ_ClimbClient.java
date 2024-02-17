package alexander.az_climb;

import alexander.az_climb.Screens.MainMenu;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

import static alexander.az_climb.AZ_Climb.MY_BLOCK_ENTITY_TYPE;
import static alexander.az_climb.block.ModBlocks.*;
import static alexander.az_climb.block_entity.ModBlockEntities.END_BLOCK_ENTITY;
import alexander.az_climb.block_entity.ModBlockEntityRenderer;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

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

            BlockEntityRendererRegistry.INSTANCE.register(MY_BLOCK_ENTITY_TYPE, ModBlockEntityRenderer::new);

            BlockRenderLayerMap.INSTANCE.putBlock(START_BLOCK, RenderLayer.getTranslucent());

            BlockRenderLayerMap.INSTANCE.putBlock(END_BLOCK, RenderLayer.getTranslucent());

            BlockRenderLayerMap.INSTANCE.putBlock(CHECKPOINT_BLOCK, RenderLayer.getTranslucent());

            BlockRenderLayerMap.INSTANCE.putBlock(DEATH_BLOCK_CLEAR, RenderLayer.getTranslucent());




        });
    }
}

