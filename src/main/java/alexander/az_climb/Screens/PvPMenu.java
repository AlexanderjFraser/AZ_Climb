package alexander.az_climb.Screens;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.client.util.math.MatrixStack;

public class PvPMenu extends Screen {

    private final Screen parentScreen;

    public PvPMenu(Screen parent) {
        super(new LiteralText("PVP Menu"));
        this.parentScreen = parent;
    }

    @Override
    protected void init() {
        super.init();
        // Define the button dimensions and positions
        int startY = this.height / 4 + 72;
        int buttonWidth = 200;
        int buttonHeight = 20;
        int spacingY = 24;


        this.addButton(new ButtonWidget(this.width - (buttonWidth/4) - 5, this.height - buttonHeight - 5, (buttonWidth/4), buttonHeight, new LiteralText("Back"), button -> {
            MinecraftClient.getInstance().openScreen(parentScreen);
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices); // Draw the default background

        // Draw the version number at the bottom left
        drawStringWithShadow(matrices, this.textRenderer, "Coming ...", this.width/2, this.height/2, 0xFFFFFF);

        super.render(matrices, mouseX, mouseY, delta); // Renders the buttons and other elements added to the screen
    }
}
