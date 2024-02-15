package alexander.az_climb.Screens;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.EntryListWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.client.util.math.MatrixStack;

public class PlayMenu extends Screen {
    private EntryListWidget mapListWidget;
    private ButtonWidget startButton;
    // Other UI components...

    public PlayMenu() {
        super(new LiteralText("mapSelection.title"));
    }

    @Override
    protected void init() {
        // Initialize and add your UI components here
        mapListWidget = new MapListWidget(/* parameters */);
        startButton = new ButtonWidget(/* parameters */, button -> startMap());
        // Other initialization...
    }



    private void startMap() {
        // Code to start the selected map
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        mapListWidget.render(matrices, mouseX, mouseY, delta);
        // Render other UI components...
        super.render(matrices, mouseX, mouseY, delta);
    }

    // Other methods...
}

