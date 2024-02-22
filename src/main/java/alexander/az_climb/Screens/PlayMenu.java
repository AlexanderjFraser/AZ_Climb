package alexander.az_climb.Screens;

import alexander.az_climb.gui_Extra.MapData;
import alexander.az_climb.gui_Extra.MapListWidget;
import alexander.az_climb.gui_Extra.MapLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.util.List;

public class PlayMenu extends Screen {
    private final Screen parentScreen;
    private MapListWidget mapListWidget;
    private ButtonWidget startButton;
    private String selectedMapId; // This should match the map's directory name in the saves folder
    private List<MapData> maps;

    public PlayMenu(Screen parent) {
        super(new TranslatableText("mapSelection.title"));
        this.parentScreen = parent;
        this.maps = MapLoader.loadMaps(MinecraftClient.getInstance()); // Load the maps here
    }

    @Override
    protected void init() {
        super.init();
        int thumbnailWidth = 40;

        // Initialize and add the start button but initially set it as inactive.
        startButton = this.addButton(new ButtonWidget(
                this.width / 2 - 100, this.height - 40, 200, 20,
                new LiteralText("Start Map"),
                button -> startSelectedMap()
        ));
        startButton.active = false; // Initially inactive

        mapListWidget = new MapListWidget(
                this.client, this.width, this.height, 32, this.height - 32,
                this::onMapSelected, maps, this // 'this' refers to the PlayMenu instance
        );
        this.addChild(mapListWidget);
    }

    public MapData getMapDataById(String mapId) {
        for (MapData map : maps) {
            if (map.getId().equals(mapId)) {
                return map;
            }
        }
        return null; // or some default MapData instance if you have one
    }

    public String getSelectedMapId() {
        return selectedMapId;
    }

    public void setSelectedMapId(String mapId) {
        this.selectedMapId = mapId;
        startButton.active = true; // Enable the start button
    }

    public void onMapSelected(MapData mapData) {
        setSelectedMapId(mapData.getId()); // Update selected map ID and enable start button
    }

    private void startSelectedMap() {
        if (selectedMapId != null && !selectedMapId.isEmpty()) {
            MinecraftClient.getInstance().execute(() -> {
                MinecraftClient.getInstance().startIntegratedServer(selectedMapId);
            });
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        mapListWidget.render(matrices, mouseX, mouseY, delta);
        super.render(matrices, mouseX, mouseY, delta);

        MapData selectedMap = getMapDataById(selectedMapId);
        if (selectedMap != null) {
            //renderMapThumbnail(matrices, selectedMap.getThumbnailIdentifier());
        }
    }

    /*
    private void renderMapThumbnail(MatrixStack matrices, Identifier thumbnailIdentifier) {
        int thumbnailWidth = 100; // Define the width for the thumbnail first
        int thumbnailHeight = 100; // Define the height for the thumbnail
        int thumbnailX = (this.width - thumbnailWidth) / 2; // Now use thumbnailWidth to calculate X
        int thumbnailY = this.height / 4; // Position it at one quarter of the screen height from the top

        MinecraftClient.getInstance().getTextureManager().bindTexture(thumbnailIdentifier);
        drawTexture(matrices, thumbnailX, thumbnailY, 0, 0, thumbnailWidth, thumbnailHeight, thumbnailWidth, thumbnailHeight);
    }

     */
}
