package alexander.az_climb.Screens;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.client.util.math.MatrixStack;

public class MainMenu extends Screen {

    public MainMenu() {
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

        // Add the buttons to the screen
        this.addButton(new ButtonWidget(this.width / 2 - buttonWidth / 2, startY, buttonWidth, buttonHeight, new LiteralText("Play"), button -> {
            MinecraftClient.getInstance().openScreen(new PlayMenu());
        }));

        this.addButton(new ButtonWidget(this.width / 2 - buttonWidth / 2, startY + spacingY, buttonWidth, buttonHeight, new LiteralText("PvP"), button -> {
            // Handle PvP button click
        }));

        this.addButton(new ButtonWidget(this.width / 2 - buttonWidth / 2, startY + 2*spacingY, buttonWidth, buttonHeight, new LiteralText("Build"), button -> {
            // Handle Build button click
        }));

        // Add other buttons similarly...

        // Add the Options and Inventory buttons
        this.addButton(new ButtonWidget((this.width / 2) - (buttonWidth / 2), startY + 3*spacingY, buttonWidth/2 - 2, buttonHeight, new LiteralText("Options..."), button -> {
            MinecraftClient.getInstance().openScreen(new ModOptionsScreen(this,MinecraftClient.getInstance().options));
        }));

        this.addButton(new ButtonWidget((this.width / 2) + 4, startY + 3*spacingY, buttonWidth/2 - 2, buttonHeight, new LiteralText("Inventory"), button -> {
            // Handle Inventory button click
        }));

        this.addButton(new ButtonWidget(this.width - (buttonWidth/4) - 5, this.height - buttonHeight - 5, (buttonWidth/4), buttonHeight, new LiteralText("Quit"), button -> {
            MinecraftClient.getInstance().openScreen(new QuitConfirmation());
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices); // Draw the default background

        // Draw the title
        drawCenteredText(matrices, this.textRenderer, new LiteralText("CLIMB MOD"), this.width / 2, 20, 0xFFFFFF);

        // Draw the splash text
        drawCenteredText(matrices, this.textRenderer, new LiteralText("Splash Text"), this.width / 2, 40, 0xFFFF00);

        // Draw the version number at the bottom left
        drawStringWithShadow(matrices, this.textRenderer, "AZ Climb mod pre-alpha", 2, this.height - 10, 0xFFFFFF);

        super.render(matrices, mouseX, mouseY, delta); // Renders the buttons and other elements added to the screen
    }
}


