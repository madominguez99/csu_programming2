package module3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.util.Random;

public class Utils {

    // Write text to a file (append mode)
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Generate a random shade of green using HSB color space
    public static Color randomGreenHSB() {
        Random r = new Random();
        float hue = 0.28f + r.nextFloat() * 0.14f;   // 100°–150° range
        float sat = 0.60f + r.nextFloat() * 0.40f;   // saturation 0.6–1.0
        float bri = 0.80f + r.nextFloat() * 0.20f;   // brightness 0.8–1.0
        return Color.getHSBColor(hue, sat, bri);
    }

    // Convert Color to hex string
    public static String colorToHex(Color c) {
        return String.format("#%02X%02X%02X", c.getRed(), c.getGreen(), c.getBlue());
    }
}
