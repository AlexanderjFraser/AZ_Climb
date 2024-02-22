package alexander.az_climb.gui_Extra;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MapData {
    private String id; // Corrected: Removed 'static'
    private final String name;
    private final String description;
    private final Identifier thumbnailIdentifier;

    public MapData(String id, String name, String description, String thumbnailPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        // Initialize thumbnailIdentifier directly without a redundant 'thumbnail' field
        this.thumbnailIdentifier = new Identifier("az_climb", thumbnailPath);
    }

    // Corrected: Removed 'static'
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Removed getThumbnail() as it's redundant

    public Identifier getThumbnailIdentifier() {
        return thumbnailIdentifier;
    }
}
