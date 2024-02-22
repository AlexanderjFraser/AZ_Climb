package alexander.az_climb.gui_Extra;

import alexander.az_climb.Screens.PlayMenu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.EntryListWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class MapListWidget extends EntryListWidget<MapListWidget.MapEntry> {
    private final PlayMenu playMenu;

    public MapListWidget(MinecraftClient client, int width, int height, int top, int bottom, Consumer<MapData> selectionCallback, List<MapData> maps, PlayMenu playMenu) {
        super(client, width, height, top, bottom, 20); // Assuming 20 is the entry height, adjust as needed.
        this.playMenu = playMenu;

        // Populate the widget with map entries
        for (MapData map : maps) {
            this.addEntry(new MapEntry(client, map, selectionCallback, playMenu));
        }
    }

    public class MapEntry extends Entry<MapListWidget.MapEntry> {
        private final MinecraftClient client;
        private final MapData mapData;
        private final Consumer<MapData> onSelectCallback;

        public MapEntry(MinecraftClient client, MapData mapData, Consumer<MapData> onSelectCallback, PlayMenu playMenu) {
            this.client = client;
            this.mapData = mapData;
            this.onSelectCallback = onSelectCallback;
        }

        @Override
        public void render(MatrixStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            Text mapName = Text.of(mapData.getName());
            this.client.textRenderer.draw(matrices, mapName, x + 2, y + 2, 0xFFFFFF);

            // Optionally, draw a thumbnail or other details as needed.
            // Example: renderThumbnail(matrices, x, y);
        }

        @Override
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (isMouseOver(mouseX, mouseY)) {
                onSelectCallback.accept(mapData);
                playMenu.setSelectedMapId(mapData.getId());
                return true;
            }
            return false;
        }

        // Example method to render a map thumbnail if needed.

        /*
        private void renderThumbnail(MatrixStack matrices, int x, int y) {
            Identifier thumbnailId = mapData.getThumbnailIdentifier();
            if (thumbnailId != null) {
                client.getTextureManager().bindTexture(thumbnailId);
                drawTexture(matrices, x, y, 0, 0, 32, 32, 32, 32);
            }
        }

        */
    }
}
