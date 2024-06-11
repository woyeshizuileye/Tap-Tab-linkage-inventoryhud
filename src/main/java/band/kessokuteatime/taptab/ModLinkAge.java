package band.kessokuteatime.taptab;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Path;

public class ModLinkAge {
    private static JsonObject inv;

    public static boolean Inventoryhud() {

        FabricLoader inventoryhud = FabricLoader.getInstance();
        Path ConfigPath = inventoryhud.getConfigDir().resolve("inventoryhud.json");
        if (inventoryhud.isModLoaded("inventoryhud")) {
            try (FileReader reader = new FileReader(String.valueOf(ConfigPath))) {
                inv = JsonParser.parseReader(reader).getAsJsonObject();
                if (inv.get("inv_toggle").getAsBoolean()) {
                    if (!inv.get("inv_mini").getAsBoolean() && !inv.get("inv_vert").getAsBoolean()){
                        return (inv.get("inv_val").toString().replace("\"","").equals("BOTTOM")) && (inv.get("inv_hal").toString().replace("\"","").equals("MIDDLE"));
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (IOException e) {
                return false;
            }
        }else {
            return false;
        }
    }
    public static int y() {
        int y = 108;
        if (Inventoryhud()) {
            y = Integer.parseInt(inv.get("inv_y").getAsString());
        }
        return y;
    }
    public static double radain08() {
        double x1 = 80, y1 = 37;
        double x2 = 72, y2 = y() - 36;
        double deltaY = y2 - y1;
        double deltaX = x2 - x1;
        double angle = Math.atan2(deltaY,deltaX);
        if (angle > Math.PI/2) {
            angle = Math.PI - angle;
        }
        return angle;
    }
    public static double radain17() {
        double x1 = 60, y1 = 37;
        double x2 = 54, y2 = y() - 36;
        double deltaY = y2 - y1;
        double deltaX = x2 - x1;
        double angle = Math.atan2(deltaY, deltaX);
        if (angle > Math.PI / 2) {
            angle = Math.PI - angle;
        }
        return angle;
    }
    public static double radain26() {
        double x1 = 40, y1 = 37;
        double x2 = 36, y2 = y() - 36;
        double deltaY = y2 - y1;
        double deltaX = x2 - x1;
        double angle = Math.atan2(deltaY, deltaX);
        if (angle > Math.PI / 2) {
            angle = Math.PI - angle;
        }
        return angle;
    }
    public static double radain35() {
        double x1 = 20, y1 = 37;
        double x2 = 18, y2 = y() - 36;
        double deltaY = y2 - y1;
        double deltaX = x2 - x1;
        double angle = Math.atan2(deltaY, deltaX);
        if (angle > Math.PI / 2) {
            angle = Math.PI - angle;
        }
        return angle;
    }
}
