package alexander.az_climb.Screens;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.client.util.math.MatrixStack;

public class QuitConfirmation extends Screen {
    private final Screen parentScreen;

    public QuitConfirmation(Screen parent) {
        super(new LiteralText("Quit Confirmation"));
        this.parentScreen = parent;
    }

    @Override
    protected void init() {
        super.init();
        // Define the button dimensions and positions
        int startY = this.height / 4 + 48;
        int buttonWidth = 50;
        int buttonHeight = 20;

        // Add the buttons to the screen
        this.addButton(new ButtonWidget((this.width / 2) - buttonWidth - 3, (this.height / 2) + 10, buttonWidth, buttonHeight, new LiteralText("Quit"), button -> {
            MinecraftClient.getInstance().scheduleStop();
        }));

        this.addButton(new ButtonWidget((this.width / 2)  + 3, (this.height / 2) + 10, buttonWidth, buttonHeight, new LiteralText("Back"), button -> {
            MinecraftClient.getInstance().openScreen(new MainMenu());
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices); // Draw the default background

        // Draw the title
        drawCenteredText(matrices, this.textRenderer, new LiteralText("Leaving So Soon.... (sorry UwU)"), this.width / 2, this.height/2 - 10, 0xFFFFFF);

        super.render(matrices, mouseX, mouseY, delta); // Renders the buttons and other elements added to the screen
    }
}
