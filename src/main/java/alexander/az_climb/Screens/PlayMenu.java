package alexander.az_climb.Screens;

import alexander.az_climb.gui_Extra.MapData;
import alexander.az_climb.gui_Extra.MapListWidget;
import alexander.az_climb.gui_Extra.MapLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.TranslatableText;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

import static alexander.az_climb.gui_Extra.MapData.getId;

public class PlayMenu extends Screen {
    private MapListWidget mapListWidget;
    private ButtonWidget startButton;
    private String selectedMapId; // This should match the map's directory name in the saves folder

    public PlayMenu() {
        super(new TranslatableText("mapSelection.title"));
    }

    @Override
    protected void init() {
        super.init();
        startButton = new ButtonWidget(
                this.width / 2 - 100, this.height - 20, 200, 20,
                new TranslatableText("menu.start"),
                button -> startSelectedMap()
        );
        startButton.active = false; // Initially disabled
        this.addButton(startButton);

        List<MapData> maps = MapLoader.loadMaps(MinecraftClient.getInstance());
        mapListWidget = new MapListWidget(this.client, this.width, this.height, 32, this.height - 32,
                mapData -> {
                    selectedMapId = mapData.getId();
                    startButton.active = true; // Enable the start button when a map is selected
                },
                maps);
        this.addChild(mapListWidget);
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
        super.render(matrices, mouseX, mouseY, delta);
        mapListWidget.render(matrices, mouseX, mouseY, delta);
    }
}