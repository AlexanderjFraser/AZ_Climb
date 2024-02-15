package alexander.az_climb.gui_Extra;

import com.google.gson.Gson;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapLoader {
    private static final Gson GSON = new Gson();

    public static List<MapData> loadMaps(MinecraftClient client) {
        List<MapData> maps = new ArrayList<>();
        ResourceManager resourceManager = client.getResourceManager();
        String[] mapNames = {"pk_beginner", "pk_newworld1", "pk_newworld2", "pk_newworld3", "pk_newworld4"};

        for (String mapName : mapNames) {
            try {
                Identifier resourceId = new Identifier("az_climb", "maps/mapdata/" + mapName + ".json");
                InputStreamReader reader = new InputStreamReader(resourceManager.getResource(resourceId).getInputStream());
                MapData mapData = GSON.fromJson(reader, MapData.class);
                // Assuming the MapData constructor and fields are adjusted accordingly
                maps.add(mapData);
            } catch (Exception e) {
                e.printStackTrace(); // Log errors for debugging
            }
        }
        return maps;
    }
}