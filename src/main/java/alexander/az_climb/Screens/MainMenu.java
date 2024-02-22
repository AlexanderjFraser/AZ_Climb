package alexander.az_climb.Screens;

import alexander.az_climb.gui_Extra.QuitButtonWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.AccessibilityOptionsScreen;
import net.minecraft.client.gui.screen.option.LanguageOptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;


public class MainMenu extends Screen {

    private static final Identifier ACCESSIBILITY_ICON_TEXTURE = new Identifier("textures/gui/accessibility.png");

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
        this.addButton(new ButtonWidget(this.width / 2 - buttonWidth / 2, startY,
                buttonWidth, buttonHeight, new LiteralText("Play"), button -> {
            MinecraftClient.getInstance().openScreen(new PlayMenu2(this));
        }));

        this.addButton(new ButtonWidget(this.width / 2 - buttonWidth / 2, startY + spacingY,
                buttonWidth, buttonHeight, new LiteralText("PvP"), button -> {
            MinecraftClient.getInstance().openScreen(new PvPMenu(this));
        }));

        this.addButton(new ButtonWidget(this.width / 2 - buttonWidth / 2, startY + 2*spacingY,
                buttonWidth, buttonHeight, new LiteralText("Build"), button -> {
            MinecraftClient.getInstance().openScreen(new SelectWorldScreen(this));
        }));

        this.addButton(new ButtonWidget((this.width / 2) - (buttonWidth / 2), startY + 3*spacingY,
                buttonWidth/2 - 2, buttonHeight, new LiteralText("Options..."), button -> {
            MinecraftClient.getInstance().openScreen(new ModOptionsScreen(this,MinecraftClient.getInstance().options));
        }));

        this.addButton(new ButtonWidget((this.width / 2) + 4, startY + 3*spacingY, buttonWidth/2 - 2,
                buttonHeight, new LiteralText("Inventory"), button -> {
            // Handle Inventory button click
        }));

        this.addButton(new QuitButtonWidget(
                this.width - (buttonWidth / 4) - 5,
                this.height - buttonHeight - 5,
                buttonWidth / 4,
                buttonHeight,
                new LiteralText("Quit"),
                button -> MinecraftClient.getInstance().openScreen(new QuitConfirmation(this))
        ));

        this.addButton(new TexturedButtonWidget(this.width / 2 - 124, startY + 3*spacingY, 20, 20, 0, 106, 20, ButtonWidget.WIDGETS_TEXTURE, 256, 256, (buttonWidget) -> {
            this.client.openScreen(new LanguageOptionsScreen(this, this.client.options, this.client.getLanguageManager()));
        }, new TranslatableText("narrator.button.language")));

        this.addButton(new TexturedButtonWidget(this.width / 2 + 104, startY + 3*spacingY, 20, 20, 0, 0, 20, ACCESSIBILITY_ICON_TEXTURE, 32, 64, (buttonWidget) -> {
            this.client.openScreen(new ModAccessibilityOptionsScreen(this, this.client.options));
        }, new TranslatableText("narrator.button.accessibility")));


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


