package alexander.az_climb.Screens;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.client.util.math.MatrixStack;

public class PvPMenu extends Screen {

    public PvPMenu() {
        super(new LiteralText("Climb Mod Main Menu"));
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
            MinecraftClient.getInstance().openScreen(new MainMenu());
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices); // Draw the default background

        // Draw the version number at the bottom left
        drawStringWithShadow(matrices, this.textRenderer, "AZ Climb mod pre-alpha", 2, this.height - 10, 0xFFFFFF);

        super.render(matrices, mouseX, mouseY, delta); // Renders the buttons and other elements added to the screen
    }
}
