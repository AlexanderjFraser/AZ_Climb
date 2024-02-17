package alexander.az_climb.gui_Extra;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MapData {
    private static String id; // New field for the resource-safe map identifier
    private final String name;
    private final String description;
    private String thumbnail = null;

    private Identifier thumbnailIdentifier;

    public MapData(String id, String name, String description, String thumbnailPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.thumbnailIdentifier = new Identifier("az_climb", thumbnail);
    }

    // Getter for the new id field
    public static String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Identifier getThumbnail() {
        return new Identifier("az_climb", thumbnail); // Adjust as necessary
    }
    public Identifier getThumbnailIdentifier() {
        return thumbnailIdentifier;
    }
}