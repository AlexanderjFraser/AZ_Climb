package alexander.az_climb.Screens;

import alexander.az_climb.gui_Extra.QuitButtonWidget;
import alexander.az_climb.gui_Extra.gauntlet_ButtonWidget;
import alexander.az_climb.gui_Extra.pk_ButtonWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import static alexander.az_climb.AZ_Climb.MOD_ID;

public class PlayMenu2 extends Screen {
    private static final Identifier PLAYMENU_BACKGROUND = new Identifier(MOD_ID, "textures/gui/playmenu_background.png");
    private final Screen parentScreen;
    private boolean drawNewBackground = false;

    public PlayMenu2(Screen parent) {
        super(new TranslatableText("mapSelection.title"));
        this.parentScreen = parent;
    }

    @Override
    protected void init() {
        super.init();
        // Define the button dimensions and positions
        int startY = this.height / 4 + 72;
        int buttonWidth = 75;
        int buttonHeight = 20;
        int spacingY = 24;

        this.addButton(new pk_ButtonWidget(
                (this.width /2) - buttonWidth - 5,
                15,
                buttonWidth,
                buttonHeight,
                new LiteralText("Parkour"),
                button -> {
                    // Set the flag to true when the button is clicked
                    drawNewBackground = true;
                    System.out.println("Parkour button clicked!");
                }
        ));

        this.addButton(new gauntlet_ButtonWidget(
                (this.width /2) + 5,
                15,
                buttonWidth,
                buttonHeight,
                new LiteralText("Gauntlet"),
                button -> {
                    // Test action: print a message to the console
                    System.out.println("Screen width: " + this.width + ", Screen height: " + this.height);
                }
        ));

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // Render the custom background
        this.renderBackgroundTexture(matrices);

        if (drawNewBackground) {
            renderNewBackgroundImage(matrices);
        }

        // Continue with the regular rendering for buttons and text
        super.render(matrices, mouseX, mouseY, delta);
    }

    private void renderNewBackgroundImage(MatrixStack matrices) {
        MinecraftClient minecraft = MinecraftClient.getInstance();
        Identifier newBackground = new Identifier(MOD_ID, "textures/gui/pk_playmenu.png");
        minecraft.getTextureManager().bindTexture(newBackground);

        // Calculate the x and y positions to center the image
        int x = (this.width - (1680/3))/2;
        int y = 70;

        // Draw the new background image
        drawTexture(matrices, x, y, 0, 0, 1680/3, 800/3, 1680/3, 800/3);
    }

    private void renderBackgroundTexture(MatrixStack matrices) {
        assert this.client != null;
        this.client.getTextureManager().bindTexture(PLAYMENU_BACKGROUND);
        int x = 0; // Starting X position of the background
        int y = 0; // Starting Y position of the background
        int width = this.width; // Make the background cover the whole screen width
        int height = this.height; // Make the background cover the whole screen height
        drawTexture(matrices, x, y, 0, 0, width, height, width, height);
    }

    @Override
    public void onClose() {
        // Navigate back to the parent screen when ESC is pressed.
        assert this.client != null;
        this.client.openScreen(parentScreen);
    }
}

