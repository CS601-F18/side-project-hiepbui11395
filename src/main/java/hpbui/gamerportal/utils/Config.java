package hpbui.gamerportal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties instance;

    private Config() {
    }

    /**
     * Get configuration file
     * @return
     */
    public static synchronized Properties getInstance() {
        if (instance == null) {
            FileInputStream is = null;

            try {
                instance = new Properties();
                is = new FileInputStream("config.properties");
                instance.load(is);
            } catch (FileNotFoundException var2) {
                var2.printStackTrace();
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

        return instance;
    }
}