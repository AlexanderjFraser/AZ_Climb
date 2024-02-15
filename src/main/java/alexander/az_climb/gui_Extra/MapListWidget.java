package alexander.az_climb.gui_Extra;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.EntryListWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import java.util.function.Consumer;

import java.util.List;

public class MapListWidget extends EntryListWidget<MapListWidget.MapEntry> {

    private Consumer<MapData> selectionCallback;

    private ButtonWidget startButton = null; // Default initialization to null

    public MapListWidget(MinecraftClient client, int width, int height, int top, int bottom, Consumer<MapData> selectionCallback, List<MapData> maps) {
        super(client, width, height, top, bottom, 20); // Height of each entry
        this.selectionCallback = selectionCallback;

        maps.forEach(map -> this.addEntry(new MapEntry(map, selectionCallback)));
    }

    private void enableStartButton() {
        // Enable the start button when a map is selected
        this.startButton.active = true;
    }


    public class MapEntry extends Entry<MapListWidget.MapEntry> {
        private final MapData mapData;
        private final Consumer<MapData> onSelectCallback;

        public MapEntry(MapData mapData, Consumer<MapData> onSelectCallback) {
            this.mapData = mapData;
            this.onSelectCallback = onSelectCallback;
        }

        public void select() {
            if (this.onSelectCallback != null) {
                this.onSelectCallback.accept(this.mapData); // Trigger the callback
            }
        }

        @Override
        public void render(MatrixStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            MinecraftClient.getInstance().textRenderer.draw(matrices, mapData.getName(), x, y, 0xFFFFFFFF);
        }

    }
}