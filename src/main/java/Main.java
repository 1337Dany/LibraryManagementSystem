import ui.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
//        Properties properties = new Properties();
//        try (
//                InputStream is = Main.class.getClassLoader()
//                        .getResourceAsStream("config.properties")
//        ) {
//            if (is == null) {
//                System.out.println("File not found");
//                return;
//            }
//
//            properties.load(is);
//
//            System.out.println(properties.getProperty("name"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        View view = new View();
        view.openMainJFrame();
    }
}